package com.example.models.game;

import com.example.models.entities.EntityManager;
import com.example.models.generation.GameRandom;
import com.example.models.items.Inventory;
import com.example.models.items.Item;
import com.example.models.items.ItemCatalog;
import com.example.models.items.Items;
import com.example.models.map.Direction;
import com.example.models.map.Room;
import com.example.models.map.Rooms;
import com.example.models.map.ShipMap;
import com.example.models.results.CrewWakeResult;

/**
 * Mutable state of a generated game.
 */
public final class GameState {
    private final ShipMap shipMap;
    private final ItemCatalog itemCatalog;
    private final EntityManager entityManager;
    private final GameRandom random;
    private int playerSteps;
    private boolean enginesRepaired;
    private boolean gameOver;
    private boolean victory;

    /**
     * Creates a game state.
     *
     * @param shipMap       ship map
     * @param itemCatalog   item catalog
     * @param entityManager entity manager
     * @param random        seeded random source
     */
    public GameState(ShipMap shipMap, ItemCatalog itemCatalog, EntityManager entityManager, GameRandom random) {
        this.shipMap = shipMap;
        this.itemCatalog = itemCatalog;
        this.entityManager = entityManager;
        this.random = random;
    }

    /**
     * Returns the room currently occupied by the player.
     *
     * @return current room
     */
    public Room getCurrentRoom() {
        return shipMap.getRoom(entityManager.getPlayer().getCurrentRoom());
    }

    /**
     * Returns a room by identifier.
     *
     * @param id room identifier
     * @return matching room
     */
    public Room getRoom(Rooms id) {
        return shipMap.getRoom(id);
    }

    /**
     * Returns the player inventory.
     *
     * @return inventory
     */
    public Inventory getInventory() {
        return entityManager.getPlayer().getInventory();
    }

    /**
     * Returns the entity manager.
     *
     * @return entity manager
     */
    public EntityManager getEntityManager() {
        return entityManager;
    }

    /**
     * Moves the player in a direction.
     *
     * @param direction movement direction
     * @return {@code true} when movement succeeds
     */
    public boolean move(Direction direction) {
        Room destination = shipMap.getConnectedRoom(getCurrentRoom(), direction);
        if (destination == null) {
            return false;
        }

        entityManager.getPlayer().moveTo(destination.getId());
        playerSteps++;

        if (playerSteps % 2 == 0) {
            entityManager.moveNonPlayerEntities(shipMap, random);
        }

        return true;
    }

    /**
     * Takes an item from the current room.
     *
     * @param item item identifier
     * @return {@code true} when the item is taken
     */
    public boolean takeItem(Items item) {
        return false;
    }

    /**
     * Places an inventory item in the current room.
     *
     * @param item item identifier
     * @return {@code true} when the item is placed
     */
    public boolean placeItem(Items item) {
        return false;
    }

    /**
     * Uses an inventory item.
     *
     * @param item item identifier
     * @return {@code true} when the item action succeeds
     */
    public boolean useItem(Items item) {
        Item definition = itemCatalog.getItem(item);
        return definition != null && definition.usable() && definition.use(this);
    }

    /**
     * Wakes the crew member.
     *
     * @return wake result
     */
    public CrewWakeResult wakeCrewMember() {
        return entityManager.wakeCrewMember(random);
    }

    /**
     * Repairs the propulsors.
     *
     * @return {@code true} when repair succeeds
     */
    public boolean repairEngines() {
        return enginesRepaired;
    }

    /**
     * Indicates whether the game is over.
     *
     * @return {@code true} when defeated
     */
    public boolean isGameOver() {
        return gameOver;
    }

    /**
     * Indicates whether the player has won.
     *
     * @return {@code true} when victorious
     */
    public boolean isVictory() {
        return victory;
    }

    /**
     * Indicates whether the game has ended.
     *
     * @return {@code true} when defeated or victorious
     */
    public boolean isFinished() {
        return gameOver || victory;
    }
}
