package com.example.models.entities;

import com.example.models.items.Inventory;
import com.example.models.map.RoomID;

/**
 * Player-controlled entity.
 */
public final class Player extends Entity {
    private final Inventory inventory;
    private boolean astronautSuitEquipped;

    /**
     * Creates the player.
     *
     * @param currentRoom initial room identifier
     */
    public Player(RoomID currentRoom) {
        super("player", "Capità Bond", currentRoom);
        inventory = new Inventory();
    }

    /**
     * Returns the player inventory.
     *
     * @return inventory
     */
    public Inventory getInventory() {
        return inventory;
    }

    /**
     * Indicates whether the astronaut suit is equipped.
     *
     * @return {@code true} when equipped
     */
    public boolean isAstronautSuitEquipped() {
        return astronautSuitEquipped;
    }

    /**
     * Sets the astronaut suit state.
     *
     * @param value {@code true} when the suit is equipped
     */
    public void setAstronautSuitEquipped(boolean value) {
        astronautSuitEquipped = value;
    }
}
