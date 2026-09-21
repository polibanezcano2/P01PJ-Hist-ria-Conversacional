package com.example.models.entities;

import com.example.models.map.Rooms;

/**
 * Sleeping crew member that can be woken by the player.
 */
public final class CrewMember extends Entity {
    private boolean asleep = true;
    private boolean wandering;

    /**
     * Creates the crew member.
     *
     * @param currentRoom initial room identifier
     */
    public CrewMember(Rooms currentRoom) {
        super("crew-member", "Tripulant", currentRoom);
    }

    /**
     * Indicates whether the crew member is asleep.
     *
     * @return {@code true} when asleep
     */
    public boolean isAsleep() {
        return asleep;
    }

    /**
     * Wakes the crew member.
     */
    public void wakeUp() {
        asleep = false;
    }

    /**
     * Indicates whether the crew member is wandering.
     *
     * @return {@code true} when wandering
     */
    public boolean isWandering() {
        return wandering;
    }

    /**
     * Enables crew member wandering.
     */
    public void startWandering() {
        wandering = true;
    }

    /**
     * Stops crew member wandering.
     */
    public void stopWandering() {
        wandering = false;
    }
}
