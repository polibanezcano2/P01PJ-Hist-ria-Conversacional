package com.example.models.entities;

import com.example.models.map.RoomID;

/**
 * Base class for every entity placed in a ship room.
 */
public abstract class Entity {
    private final String id;
    private final String name;
    private RoomID currentRoom;

    /**
     * Creates an entity.
     *
     * @param id          stable entity identifier
     * @param name        display name
     * @param currentRoom initial room identifier
     */
    protected Entity(String id, String name, RoomID currentRoom) {
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
    public RoomID getCurrentRoom() {
        return currentRoom;
    }

    /**
     * Moves this entity to another room.
     *
     * @param room destination room identifier
     */
    public void moveTo(RoomID room) {
        currentRoom = room;
    }
}
