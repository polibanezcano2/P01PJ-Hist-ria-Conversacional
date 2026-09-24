package com.example.utils.ui.helpers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.example.models.actions.RoomAction;
import com.example.models.entities.Entity;
import com.example.models.game.GameState;
import com.example.models.items.Item;
import com.example.models.map.Direction;
import com.example.models.map.Room;
import com.example.models.map.RoomID;

/**
 * Builds mutable option lists for console menus.
 */
public final class GameMenuBuilder {
    private GameMenuBuilder() {
        throw new UnsupportedOperationException("Utility class");
    }

    /**
     * Builds the labels shown in the navigation menu.
     *
     * @param state current game state used to resolve room identifiers
     * @param exits available exits from the current room
     * @return mutable option list with one label per exit
     */
    public static List<String> createNavigationOptions(GameState state, List<Map.Entry<Direction, RoomID>> exits) {
        List<String> options = new ArrayList<>();

        for (Map.Entry<Direction, RoomID> exit : exits) {
            Room destination = state.getRoom(exit.getValue());
            if (destination == null) {
                options.add("Sortida desconeguda");
            } else {
                options.add(destination.getName());
            }
        }

        options.add("Tornar");

        return options;
    }

    /**
     * Builds the labels shown in the map menu.
     *
     * <p>
     * The returned list keeps the same order as the entity list and appends a
     * final option for going back.
     *
     * @param entities entities available for map inspection
     * @return mutable option list with entity labels and a back option
     */
    public static List<String> createMapMenuOptions(List<Entity> entities) {
        List<String> options = new ArrayList<>();
        for (Entity entity : entities) {
            options.add(EntityDisplayer.formatEntityName(entity));
        }
        options.add("Tornar");

        return options;
    }

    /**
     * Builds the labels shown in the inventory menu.
     *
     * <p>
     * The returned list keeps the same order as the item list and appends a final
     * option for going back.
     *
     * @param items inventory item definitions
     * @return mutable option list with item labels and a back option
     */
    public static List<String> createInventoryMenuOptions(List<Item> items) {
        List<String> options = new ArrayList<>();
        for (Item item : items) {
            options.add(item.name());
        }
        options.add("Tornar");

        return options;
    }

    /**
     * Builds the labels shown in an item detail menu.
     *
     * <p>
     * Only commands supported by the item are included. A final back option is
     * always appended.
     *
     * @param item selected item definition
     * @return mutable option list with available item commands and a back option
     */
    public static List<String> createItemMenuOptions(Item item) {
        List<String> options = new ArrayList<>();
        if (item.usable()) {
            options.add("Usar");
        }
        if (item.placeable()) {
            options.add("Col·locar");
        }
        options.add("Tornar");

        return options;
    }

    /**
     * Builds the labels shown in the interaction menu.
     *
     * <p>
     * The returned list keeps the same order as the action list and appends a
     * final option for going back.
     *
     * @param actions room actions available for interaction
     * @return mutable option list with action labels and a back option
     */
    public static List<String> createInteractionMenu(List<RoomAction> actions) {
        List<String> options = new ArrayList<>();
        for (RoomAction action : actions) {
            options.add(action.getDisplayName());
        }
        options.add("Tornar");

        return options;
    }
}
