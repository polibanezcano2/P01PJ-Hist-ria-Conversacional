package com.example.models.map;

/**
 * Interactive places inside rooms that are not inventory items.
 */
public enum RoomFeature {
    /** Flooded bathroom drain where hidden objects can be recovered later. */
    FLOODED_DRAIN("Desguàs inundat", "Un punt inundat del bany que cal inspeccionar sota l'aigua.");

    private final String name;
    private final String description;

    RoomFeature(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * Returns the display name.
     *
     * @return display name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the feature description.
     *
     * @return feature description
     */
    public String getDescription() {
        return description;
    }
}
