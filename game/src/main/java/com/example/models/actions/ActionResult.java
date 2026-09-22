package com.example.models.actions;

/**
 * Result of executing an action.
 *
 * <p>
 * This result carries only success state and UI text. Turn consumption is
 * controlled by the submenu that executed the action.
 */
public record ActionResult(boolean success, String message) {
    /**
     * Creates a successful result.
     *
     * @param message optional result message
     * @return action result
     */
    public static ActionResult success(String message) {
        return new ActionResult(true, message);
    }

    /**
     * Creates a failed result.
     *
     * @param message optional result message
     * @return action result
     */
    public static ActionResult failure(String message) {
        return new ActionResult(false, message);
    }
}
