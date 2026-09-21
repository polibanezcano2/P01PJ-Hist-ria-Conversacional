package com.example.models.entities;

import com.example.models.game.GameState;
import com.example.models.generation.GameRandom;
import com.example.models.map.ShipMap;
import com.example.models.results.CrewWakeResult;
import com.example.models.results.CrewWakeResultType;

/**
 * Owns the game entities and coordinates entity-level events.
 */
public final class EntityManager {
    private final Player player;
    private final Malien malien;
    private final CrewMember crewMember;

    /**
     * Creates an entity manager.
     *
     * @param player     player entity
     * @param malien     hostile entity
     * @param crewMember single crew member NPC
     */
    public EntityManager(Player player, Malien malien, CrewMember crewMember) {
        this.player = player;
        this.malien = malien;
        this.crewMember = crewMember;
    }

    /**
     * Returns the player entity.
     *
     * @return player
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Returns Malien.
     *
     * @return Malien
     */
    public Malien getMalien() {
        return malien;
    }

    /**
     * Returns the crew member.
     *
     * @return crew member
     */
    public CrewMember getCrewMember() {
        return crewMember;
    }

    /**
     * Moves non-player entities.
     *
     * <p>
     * Empty scaffold: real movement rules will be implemented later.
     *
     * @param shipMap ship map
     * @param random  seeded random source
     */
    public void moveNonPlayerEntities(ShipMap shipMap, GameRandom random) {
        malien.reduceDistraction();
    }

    /**
     * Checks whether Malien meets the player.
     *
     * @param state current game state
     * @return {@code true} when the encounter ends the game
     */
    public boolean checkMalienEncounter(GameState state) {
        return false;
    }

    /**
     * Wakes the crew member if the action is valid.
     *
     * @param random seeded random source
     * @return wake result placeholder
     */
    public CrewWakeResult wakeCrewMember(GameRandom random) {
        if (!crewMember.isAsleep()) {
            return new CrewWakeResult(CrewWakeResultType.ALREADY_AWAKE, "");
        }

        crewMember.wakeUp();
        return new CrewWakeResult(CrewWakeResultType.TRUE_HINT, "");
    }
}
