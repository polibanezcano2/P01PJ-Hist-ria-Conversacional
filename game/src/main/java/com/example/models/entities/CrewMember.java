package com.example.models.entities;

import com.example.models.map.Rooms;

/**
 * Sleeping crew member that can be woken by the player.
 */
public final class CrewMember extends Entity implements TurnActor {
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
     * Wakes the crew member when still asleep.
     *
     * @return wake result
     */
    public WakeResult wakeUp() {
        if (!asleep) {
            return new WakeResult(WakeResultType.ALREADY_AWAKE, "");
        }

        asleep = false;
        return new WakeResult(WakeResultType.TRUE_HINT, "");
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

    /**
     * Executes the crew member's turn.
     *
     * <p>
     * Scaffold: sleeping crew members do nothing. Future wandering and hint logic
     * belongs here.
     */
    @Override
    public void takeTurn(com.example.models.game.GameState state) {
        if (asleep || !wandering) {
            return;
        }
    }

    /**
     * Structured result produced after trying to wake the crew member.
     */
    public record WakeResult(WakeResultType type, String message) {
    }

    /**
     * Possible structured outcomes of waking the crew member.
     */
    public enum WakeResultType {
        /** The crew member gives a useful hint. */
        TRUE_HINT,

        /** The crew member gives a false hint. */
        FALSE_HINT,

        /** The crew member starts wandering around the ship. */
        START_WANDERING,

        /** The crew member eats a donut. */
        EAT_DONUT,

        /** The player is not in the same room as the crew member. */
        NOT_IN_ROOM,

        /** The crew member was already awake. */
        ALREADY_AWAKE
    }
}
