package com.example.controllers;

import com.example.models.actions.ActionResult;
import com.example.models.actions.RoomAction;
import com.example.models.game.GameState;

/**
 * Resolves actions selected from a room interaction menu.
 *
 * <p>
 * Room actions are responsible for deciding whether inventory objects matter in
 * that room. For example, the snorkel should not solve anything when used
 * directly from the inventory; the flooded-drain room action should inspect the
 * inventory and decide whether the player can see under the water.
 */
public final class RoomActionHandler {
    /**
     * Prevents instantiation.
     */
    private RoomActionHandler() {
        throw new UnsupportedOperationException("Utility class");
    }

    /**
     * Executes a room-specific action against the current game state.
     *
     * @param action room action selected by the player
     * @param state  current game state to inspect and mutate
     * @return result message for the UI
     */
    public static ActionResult handle(RoomAction action, GameState state) {
        return ActionResult.success("");
    }
}
