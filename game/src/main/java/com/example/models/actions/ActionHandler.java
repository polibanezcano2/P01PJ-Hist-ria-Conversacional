package com.example.models.actions;

import com.example.models.game.GameState;

/**
 * Dispatches top-level menu actions to future submenu handlers.
 *
 * <p>
 * This class is intentionally an empty scaffold while the menu navigation is
 * being defined.
 */
public final class ActionHandler {
    @SuppressWarnings("unused")
    private final GameState state;

    /**
     * Creates an action handler.
     *
     * @param state game state to mutate
     */
    public ActionHandler(GameState state) {
        this.state = state;
    }

    /**
     * Handles a player menu request.
     *
     * @param request action request
     * @return action result
     */
    public ActionResult handle(ActionType request) {
        return switch (request) {
            case NAVIGATION -> handleNavigation();
            case INVENTORY -> handleInventory();
            case MAP -> handleMap();
            case INTERACTION -> handleInteraction();
            case WAIT -> handleWait();
            case EXIT -> ActionResult.success("");
        };
    }

    private ActionResult handleNavigation() {
        return ActionResult.success("");
    }

    private ActionResult handleInventory() {
        return ActionResult.success("");
    }

    private ActionResult handleMap() {
        return ActionResult.success("");
    }

    private ActionResult handleInteraction() {
        return ActionResult.success("");
    }

    /**
     * Handles a room-specific action selected from the interaction submenu.
     *
     * @param action room action
     * @return action result
     */
    public ActionResult handle(RoomAction action) {
        return switch (action) {
            case SEARCH_CAPSULE,
                    CHECK_LOCKER,
                    INSPECT_FLOODED_DRAIN,
                    DRAIN_WATER,
                    SEARCH_TABLE,
                    TALK_CREW,
                    SEARCH_PANTRY,
                    PREPARE_BAIT,
                    CHECK_TERMINAL,
                    OPEN_DESK,
                    OPEN_SUIT_LOCKER,
                    EQUIP_SUIT,
                    SEARCH_TOOLS,
                    CALIBRATE_TOOL,
                    INSPECT_ENGINES,
                    REPAIR_ENGINES,
                    CHECK_SHIP_MAP,
                    START_ENGINES -> ActionResult.success("");
        };
    }

    private ActionResult handleWait() {
        return ActionResult.success("");
    }
}
