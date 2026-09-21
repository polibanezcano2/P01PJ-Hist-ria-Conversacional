package com.example.models.entities;

import com.example.models.map.Rooms;

/**
 * Base class for every entity placed in a ship room.
 */
public abstract class Entity {
    private final String id;
    private final String name;
    private Rooms currentRoom;

    /**
     * Creates an entity.
     *
     * @param id          stable entity identifier
     * @param name        display name
     * @param currentRoom initial room identifier
     */
    protected Entity(String id, String name, Rooms currentRoom) {
        this.id = id;
        this.name = name;
        this.currentRoom = currentRoom;
    }

    /**
     * Returns the entity identifier.
     *
     * @return entity identifier
     */
    public String getId() {
        return id;
    }

    /**
     * Returns the entity display name.
     *
     * @return display name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the room where this entity currently is.
     *
     * @return current room identifier
     */
    public Rooms getCurrentRoom() {
        return currentRoom;
    }

    /**
     * Moves this entity to another room.
     *
     * @param room destination room identifier
     */
    public void moveTo(Rooms room) {
        currentRoom = room;
    }
}
