package com.example.models.results;

/**
 * Possible structured outcomes of waking the crew member.
 */
public enum CrewWakeResultType {
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
    ALREADY_AWAKE;
}
