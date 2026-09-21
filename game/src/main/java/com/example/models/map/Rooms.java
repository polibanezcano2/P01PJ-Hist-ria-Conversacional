package com.example.models.map;

/**
 * Stable identifiers for the ship rooms.
 *
 * <p>
 * This enum is intentionally used as an identifier list, not as the full room
 * object. The full room data is stored in {@link Room}, and the map that relates
 * these identifiers to real rooms is built by {@link ShipMap}.
 */
public enum Rooms {
    /** Ship workshop. */
    WORKSHOPS,

    /** Astronaut suit changing room. */
    COSTUME,

    /** Ship kitchen. */
    KITCHEN,

    /** Ship bathrooms. */
    BATHROOM,

    /** Crew bedroom. */
    BEDROOM,

    /** Central offices area. */
    OFFICES,

    /** Dining room. */
    LIVING_ROOM,

    /** Exterior exit room. */
    EXIT_ROOM,

    /** Command room. */
    COMMAND;

    /** Cached enum values for indexed access. */
    protected static final Rooms[] VALUES = values();
}
