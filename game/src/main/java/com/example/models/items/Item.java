package com.example.models.items;

import com.example.models.game.GameState;

/**
 * Describes an item available in the escape room.
 */
public record Item(Items id, String name, String description, boolean placeable, boolean usable, ItemUseAction useAction) {
    /**
     * Executes the item action if one is defined.
     *
     * @param state current game state
     * @return {@code true} when the action succeeds
     */
    public boolean use(GameState state) {
        return useAction != null && useAction.execute(state, id);
    }
}
