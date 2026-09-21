package com.example.models.actions;

/**
 * Result of executing a player action.
 */
public record ActionResult(boolean success, String message, boolean consumesTurn) {
    /**
     * Creates a successful result.
     *
     * @param message optional result message
     * @return action result
     */
    public static ActionResult success(String message) {
        return new ActionResult(true, message, false);
    }

    /**
     * Creates a successful result that consumes a turn.
     *
     * @param message optional result message
     * @return action result
     */
    public static ActionResult successTurn(String message) {
        return new ActionResult(true, message, true);
    }

    /**
     * Creates a failed result.
     *
     * @param message optional result message
     * @return action result
     */
    public static ActionResult failure(String message) {
        return new ActionResult(false, message, false);
    }

    /**
     * Creates a failed result that still consumes a turn.
     *
     * @param message optional result message
     * @return action result
     */
    public static ActionResult failureTurn(String message) {
        return new ActionResult(false, message, true);
    }
}
