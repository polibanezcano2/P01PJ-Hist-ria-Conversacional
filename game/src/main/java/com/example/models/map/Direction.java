package com.example.models.map;

/**
 * Cardinal directions used to connect rooms in the ship map.
 */
public enum Direction {
    /** North direction. */
    NORTH("Nord"),

    /** South direction. */
    SOUTH("Sud"),

    /** East direction. */
    EAST("Est"),

    /** West direction. */
    WEST("Oest");

    private final String displayName;

    Direction(String displayName) {
        this.displayName = displayName;
    }

    /**
     * Returns the direction that goes back through the same connection.
     *
     * @return opposite direction
     */
    public Direction opposite() {
        return switch (this) {
            case NORTH -> SOUTH;
            case SOUTH -> NORTH;
            case EAST -> WEST;
            case WEST -> EAST;
        };
    }

    /**
     * Returns the label shown to the player.
     *
     * @return display name
     */
    public String getDisplayName() {
        return displayName;
    }
}
