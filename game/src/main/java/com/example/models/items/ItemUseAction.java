package com.example.models.items;

import com.example.models.game.GameState;

/**
 * Behavior executed when a usable item is used.
 */
@FunctionalInterface
public interface ItemUseAction {
    /**
     * Executes an item action against the current game state.
     *
     * @param state current game state
     * @param item  item being used
     * @return {@code true} when the action succeeds
     */
    boolean execute(GameState state, Items item);
}
