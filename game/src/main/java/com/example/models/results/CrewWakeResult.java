package com.example.models.results;

/**
 * Structured result produced after trying to wake the crew member.
 */
public final class CrewWakeResult {
    private final CrewWakeResultType type;
    private final String message;

    /**
     * Creates a wake result.
     *
     * @param type    result type
     * @param message optional message
     */
    public CrewWakeResult(CrewWakeResultType type, String message) {
        this.type = type;
        this.message = message;
    }

    /**
     * Returns the result type.
     *
     * @return result type
     */
    public CrewWakeResultType getType() {
        return type;
    }

    /**
     * Returns the result message.
     *
     * @return result message
     */
    public String getMessage() {
        return message;
    }
}
