package com.example.models.entities;

import com.example.models.map.RoomID;

/**
 * Hostile entity that threatens the player.
 *
 * <p>
 * Malien can be distracted for a limited number of world turns. Each time
 * Malien takes a turn, the remaining distraction duration is reduced.
 */
public final class Malien extends Entity implements TurnActor {
    private int distractedTurns;

    /**
     * Creates Malien.
     *
     * @param currentRoom initial room identifier
     */
    public Malien(RoomID currentRoom) {
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
     * Returns how many turns Malien will remain distracted.
     *
     * @return remaining distraction turns
     */
    public int getDistractedTurns() {
        return distractedTurns;
    }

    /**
     * Distracts Malien for a number of turns.
     *
     * @param turns distraction duration; negative values are treated as zero
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

    /**
     * Executes Malien's turn by updating temporary status effects.
     *
     * @param state current game state
     */
    @Override
    public void takeTurn(com.example.models.game.GameState state) {
        reduceDistraction();
    }
}
