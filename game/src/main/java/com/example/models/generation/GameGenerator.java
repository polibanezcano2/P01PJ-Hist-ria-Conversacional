package com.example.models.generation;

import com.example.models.entities.CrewMember;
import com.example.models.entities.EntityManager;
import com.example.models.entities.Malien;
import com.example.models.entities.Player;
import com.example.models.game.GameState;
import com.example.models.items.ItemCatalog;
import com.example.models.items.Items;
import com.example.models.map.Rooms;
import com.example.models.map.ShipMap;

/**
 * Creates a game state from a seeded generator.
 */
public final class GameGenerator {
    private final GameRandom random;

    /**
     * Creates a game generator.
     *
     * @param random seeded random source
     */
    public GameGenerator(GameRandom random) {
        this.random = random;
    }

    /**
     * Generates a complete game scaffold.
     *
     * @return generated game state
     */
    public GameState generate() {
        ShipMap shipMap = createShipMap();
        ItemCatalog itemCatalog = createItemCatalog();
        EntityManager entityManager = createEntityManager();
        placeInitialItems(shipMap);
        return new GameState(shipMap, itemCatalog, entityManager, random);
    }

    /**
     * Creates the ship map.
     *
     * @return ship map
     */
    private ShipMap createShipMap() {
        return new ShipMap();
    }

    /**
     * Creates the item catalog.
     *
     * @return item catalog
     */
    private ItemCatalog createItemCatalog() {
        return new ItemCatalog();
    }

    /**
     * Creates the starting entities.
     *
     * @return entity manager
     */
    private EntityManager createEntityManager() {
        Player player = new Player(Rooms.BEDROOM);
        Malien malien = new Malien(Rooms.OFFICES);
        CrewMember crewMember = new CrewMember(Rooms.LIVING_ROOM);
        return new EntityManager(player, malien, crewMember);
    }

    /**
     * Places initial known items in rooms.
     *
     * <p>
     * Empty scaffold with fixed placement. Seed-based distribution rules will be
     * added later.
     *
     * @param shipMap ship map to populate
     */
    private void placeInitialItems(ShipMap shipMap) {
        shipMap.getRoom(Rooms.COSTUME).addItem(Items.ASTRONAUT_SUIT);
        shipMap.getRoom(Rooms.WORKSHOPS).addItem(Items.REPAIR_TOOL);
        shipMap.getRoom(Rooms.KITCHEN).addItem(Items.DONUT);
        shipMap.getRoom(Rooms.LIVING_ROOM).addItem(Items.SNORKEL);
    }
}
