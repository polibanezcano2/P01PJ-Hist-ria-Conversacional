package com.example.models.game;

/**
 * Progress markers used by puzzles and prefabricated routes.
 */
public enum GameFlag {
    /** The selected route expects the card to be found through the flooded drain. */
    ROUTE_DRAIN_CARD,

    /** The selected route expects the card to be obtained from the crew member. */
    ROUTE_CREW_CARD,

    /** The selected route expects the card to be found in the offices. */
    ROUTE_OFFICE_CARD,

    /** The flooded drain has been inspected with the right tool. */
    FLOODED_DRAIN_INSPECTED,

    /** The crew card has been noticed but not necessarily recovered. */
    CREW_CARD_SPOTTED,

    /** The crew card is already recovered. */
    CREW_CARD_RECOVERED,

    /** Malien is temporarily distracted. */
    MALIEN_DISTRACTED,

    /** Engines have been inspected. */
    ENGINES_INSPECTED,

    /** Engines have been repaired. */
    ENGINES_REPAIRED
}
