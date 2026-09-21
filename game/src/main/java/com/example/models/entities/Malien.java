package com.example.models.entities;

import com.example.models.map.Rooms;

/**
 * Hostile entity that threatens the player.
 */
public final class Malien extends Entity {
    private int distractedTurns;

    /**
     * Creates Malien.
     *
     * @param currentRoom initial room identifier
     */
    public Malien(Rooms currentRoom) {
        super("malien", "Malien", currentRoom);
    }

    /**
     * Indicates whether Malien is currently distracted.
     *
     * @return {@code true} while distraction turns remain
     */
    public boolean isDistracted() {
        return distractedTurns > 0;
    }

    /**
     * Distracts Malien for a number of turns.
     *
     * @param turns distraction duration
     */
    public void distract(int turns) {
        distractedTurns = Math.max(0, turns);
    }

    /**
     * Reduces the remaining distraction duration by one turn.
     */
    public void reduceDistraction() {
        if (distractedTurns > 0) {
            distractedTurns--;
        }
    }
}
