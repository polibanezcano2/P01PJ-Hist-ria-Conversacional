package com.example.models.map;

import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;
import java.util.Set;

import com.example.models.actions.RoomAction;
import com.example.models.items.Items;

/**
 * Represents a ship room without directly referencing other room objects.
 *
 * <p>
 * Connections are stored as {@link Rooms} identifiers. The {@link ShipMap}
 * resolves those identifiers into actual {@code Room} instances when navigation
 * needs them. Room items and actions are stored as identifiers for the same
 * reason.
 */
public final class Room {
    private final Rooms id;
    private final String name;
    private final String description;
    private final Map<Direction, Rooms> connections = new EnumMap<>(Direction.class);
    private final Set<Items> items = EnumSet.noneOf(Items.class);
    private final Set<RoomAction> actions = EnumSet.noneOf(RoomAction.class);

    /**
     * Creates a room.
     *
     * @param id          stable room identifier
     * @param name        display name
     * @param description short room description
     */
    public Room(Rooms id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    /**
     * Adds or replaces a directional connection.
     *
     * @param direction direction from this room
     * @param roomId    destination room identifier
     */
    public void connect(Direction direction, Rooms roomId) {
        connections.put(direction, roomId);
    }

    /**
     * Returns the room identifier.
     *
     * @return room identifier
     */
    public Rooms getId() {
        return id;
    }

    /**
     * Returns the room display name.
     *
     * @return display name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the room description.
     *
     * @return room description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the destination room identifier for a direction.
     *
     * @param direction direction to inspect
     * @return destination room identifier, or {@code null} when there is no exit
     */
    public Rooms getConnection(Direction direction) {
        return connections.get(direction);
    }

    /**
     * Returns a read-only view of all room connections.
     *
     * @return read-only connections by direction
     */
    public Map<Direction, Rooms> getConnections() {
        return Collections.unmodifiableMap(connections);
    }

    /**
     * Adds an item identifier to the room.
     *
     * @param itemId item identifier
     * @return {@code true} if the item was not already present
     */
    public boolean addItem(Items itemId) {
        return items.add(itemId);
    }

    /**
     * Removes an item identifier from the room.
     *
     * @param itemId item identifier
     * @return {@code true} if the item was present
     */
    public boolean removeItem(Items itemId) {
        return items.remove(itemId);
    }

    /**
     * Indicates whether this room currently contains an item.
     *
     * @param item item identifier
     * @return {@code true} when the item is present
     */
    public boolean hasItem(Items item) {
        return items.contains(item);
    }

    /**
     * Returns a read-only view of the item identifiers currently in this room.
     *
     * @return read-only item identifiers
     */
    public Set<Items> getItems() {
        return Collections.unmodifiableSet(items);
    }

    /**
     * Adds an action available from this room.
     *
     * @param action action identifier
     * @return {@code true} if the action was not already present
     */
    public boolean addAction(RoomAction action) {
        return actions.add(action);
    }

    /**
     * Indicates whether this room offers an action.
     *
     * @param action action identifier
     * @return {@code true} when the action is available
     */
    public boolean hasAction(RoomAction action) {
        return actions.contains(action);
    }

    /**
     * Returns a read-only view of the actions available in this room.
     *
     * @return read-only room action identifiers
     */
    public Set<RoomAction> getActions() {
        return Collections.unmodifiableSet(actions);
    }
}
