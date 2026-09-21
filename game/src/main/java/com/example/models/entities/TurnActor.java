package com.example.models.entities;

import com.example.models.game.GameState;

/**
 * Entity that can act during the world turn.
 */
public interface TurnActor {
    /**
     * Executes one non-player turn.
     *
     * @param state current game state
     */
    void takeTurn(GameState state);
}
