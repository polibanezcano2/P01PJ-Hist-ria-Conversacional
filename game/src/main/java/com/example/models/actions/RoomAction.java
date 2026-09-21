package com.example.models.actions;

import com.example.models.map.RoomFeature;

/**
 * Room-specific actions prepared for future escape-room puzzles.
 */
public enum RoomAction {
    /** Search the cryosleep capsule area. */
    SEARCH_CAPSULE("Registrar càpsula"),

    /** Check the personal locker in the bedroom. */
    CHECK_LOCKER("Revisar taquilla"),

    /** Inspect the flooded drain without taking anything directly. */
    INSPECT_FLOODED_DRAIN("Mirar sota l'aigua", RoomFeature.FLOODED_DRAIN),

    /** Try to lower or redirect the bathroom water. */
    DRAIN_WATER("Drenar aigua", RoomFeature.FLOODED_DRAIN),

    /** Search the dining table. */
    SEARCH_TABLE("Registrar taula"),

    /** Talk to the crew member if present. */
    TALK_CREW("Parlar amb tripulant"),

    /** Search the pantry for food or bait. */
    SEARCH_PANTRY("Registrar rebost"),

    /** Prepare bait for Malien. */
    PREPARE_BAIT("Preparar esquer"),

    /** Check the office terminal. */
    CHECK_TERMINAL("Consultar terminal"),

    /** Open the office desk. */
    OPEN_DESK("Obrir escriptori"),

    /** Open the suit locker. */
    OPEN_SUIT_LOCKER("Obrir armari del vestit"),

    /** Equip the astronaut suit. */
    EQUIP_SUIT("Equipar vestit"),

    /** Search the workshop tools. */
    SEARCH_TOOLS("Registrar eines"),

    /** Repair or calibrate the repair tool. */
    CALIBRATE_TOOL("Calibrar eina"),

    /** Inspect the damaged engines. */
    INSPECT_ENGINES("Inspeccionar motors"),

    /** Repair the damaged engines. */
    REPAIR_ENGINES("Reparar motors"),

    /** Check ship and entity positions. */
    CHECK_SHIP_MAP("Consultar mapa"),

    /** Start the engines after repairs. */
    START_ENGINES("Engegar motors");

    private final String displayName;
    private final RoomFeature feature;

    RoomAction(String displayName) {
        this(displayName, null);
    }

    RoomAction(String displayName, RoomFeature feature) {
        this.displayName = displayName;
        this.feature = feature;
    }

    /**
     * Returns the label shown in room interaction submenus.
     *
     * @return action label
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * Returns the room feature this action targets.
     *
     * @return target feature, or {@code null} when the action is not tied to a
     *         specific room feature
     */
    public RoomFeature getFeature() {
        return feature;
    }

    /**
     * Indicates whether this action targets a specific room feature.
     *
     * @return {@code true} when a feature is associated with the action
     */
    public boolean hasFeature() {
        return feature != null;
    }
}
