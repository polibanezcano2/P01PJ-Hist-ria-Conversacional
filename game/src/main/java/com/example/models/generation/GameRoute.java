package com.example.models.generation;

import com.example.models.entities.EntityManager;
import com.example.models.game.GameState;
import com.example.models.map.ShipMap;

/**
 * Game routes prepared for future implementation.
 *
 * <p>
 * This enum is intentionally minimal: concrete route setup should be implemented
 * by hand later.
 */
public enum GameRoute {
    /** Empty route used while the game is still a scaffold. */
    SCAFFOLD("Ruta pendent") {
        @Override
        public void setup(ShipMap shipMap, EntityManager entityManager) {
        }

        @Override
        public void setupState(GameState state) {
        }
    };

    private final String displayName;

    GameRoute(String displayName) {
        this.displayName = displayName;
    }

    /**
     * Applies the route setup to the generated game objects.
     *
     * @param shipMap       ship map to populate
     * @param entityManager entities to position
     */
    public abstract void setup(ShipMap shipMap, EntityManager entityManager);

    /**
     * Applies route-specific state flags.
     *
     * @param state generated state
     */
    protected abstract void setupState(GameState state);

    /**
     * Returns a player-readable route name.
     *
     * @return display name
     */
    public String getDisplayName() {
        return displayName;
    }
}
