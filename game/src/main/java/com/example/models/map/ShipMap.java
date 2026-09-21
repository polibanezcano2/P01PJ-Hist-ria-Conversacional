package com.example.models.map;

import java.util.EnumMap;
import java.util.Map;

import com.example.models.actions.RoomAction;

/**
 * Builds and owns the ship room graph.
 *
 * <p>
 * This class creates rooms and their connections. Initial item placement belongs
 * to the game generator so that each game can use a seed.
 */
public final class ShipMap {
    private final Map<Rooms, Room> rooms = new EnumMap<>(Rooms.class);

    /**
     * Creates the default ship map.
     */
    public ShipMap() {
        createRooms();
        connectRooms();
    }

    /**
     * Returns the starting room for the game.
     *
     * @return starting room
     */
    public Room getStartingRoom() {
        return getRoom(Rooms.BEDROOM);
    }

    /**
     * Returns a room by identifier.
     *
     * @param id room identifier
     * @return matching room
     */
    public Room getRoom(Rooms id) {
        return rooms.get(id);
    }

    /**
     * Returns the room reached from another room in a given direction.
     *
     * @param from      current room
     * @param direction movement direction
     * @return destination room, or {@code null} when there is no exit
     */
    public Room getConnectedRoom(Room from, Direction direction) {
        Rooms destinationId = from.getConnection(direction);
        return destinationId == null ? null : getRoom(destinationId);
    }

    /**
     * Creates every room object before any connection is added.
     */
    private void createRooms() {
        add(new Room(Rooms.WORKSHOPS, "Tallers", "Zona on es guarden eines i peces de reparació."));
        add(new Room(Rooms.COSTUME, "Vestuari", "Sala amb equipament per sortir a l'exterior."));
        add(new Room(Rooms.KITCHEN, "Cuina", "Espai de menjar i subministraments."));
        add(new Room(Rooms.BATHROOM, "Banys", "Zona inundada de banys de la tripulació."));
        add(new Room(Rooms.BEDROOM, "Dormitori", "Zona d'hibernació i descans de la tripulació."));
        add(new Room(Rooms.OFFICES, "Oficines", "Zona central de treball de la nau."));
        add(new Room(Rooms.LIVING_ROOM, "Menjador", "Sala comuna on menja la tripulació."));
        add(new Room(Rooms.EXIT_ROOM, "Sala sortida exterior", "Accés per sortir de la nau."));
        add(new Room(Rooms.COMMAND, "Comandament", "Sala de control de la nau."));

        addRoomActions();
    }

    private void addRoomActions() {
        getRoom(Rooms.BEDROOM).addAction(RoomAction.SEARCH_CAPSULE);
        getRoom(Rooms.BEDROOM).addAction(RoomAction.CHECK_LOCKER);

        getRoom(Rooms.BATHROOM).addAction(RoomAction.INSPECT_FLOODED_DRAIN);
        getRoom(Rooms.BATHROOM).addAction(RoomAction.DRAIN_WATER);

        getRoom(Rooms.LIVING_ROOM).addAction(RoomAction.SEARCH_TABLE);
        getRoom(Rooms.LIVING_ROOM).addAction(RoomAction.TALK_CREW);

        getRoom(Rooms.KITCHEN).addAction(RoomAction.SEARCH_PANTRY);
        getRoom(Rooms.KITCHEN).addAction(RoomAction.PREPARE_BAIT);

        getRoom(Rooms.OFFICES).addAction(RoomAction.CHECK_TERMINAL);
        getRoom(Rooms.OFFICES).addAction(RoomAction.OPEN_DESK);

        getRoom(Rooms.COSTUME).addAction(RoomAction.OPEN_SUIT_LOCKER);
        getRoom(Rooms.COSTUME).addAction(RoomAction.EQUIP_SUIT);

        getRoom(Rooms.WORKSHOPS).addAction(RoomAction.SEARCH_TOOLS);
        getRoom(Rooms.WORKSHOPS).addAction(RoomAction.CALIBRATE_TOOL);

        getRoom(Rooms.EXIT_ROOM).addAction(RoomAction.INSPECT_ENGINES);
        getRoom(Rooms.EXIT_ROOM).addAction(RoomAction.REPAIR_ENGINES);

        getRoom(Rooms.COMMAND).addAction(RoomAction.CHECK_SHIP_MAP);
        getRoom(Rooms.COMMAND).addAction(RoomAction.START_ENGINES);
    }

    /**
     * Defines the ship layout using bidirectional room connections.
     */
    private void connectRooms() {
        connect(Rooms.BEDROOM, Direction.NORTH, Rooms.BATHROOM);
        connect(Rooms.BEDROOM, Direction.WEST, Rooms.LIVING_ROOM);
        connect(Rooms.BATHROOM, Direction.WEST, Rooms.OFFICES);
        connect(Rooms.OFFICES, Direction.NORTH, Rooms.WORKSHOPS);
        connect(Rooms.OFFICES, Direction.WEST, Rooms.COSTUME);
        connect(Rooms.OFFICES, Direction.SOUTH, Rooms.COMMAND);
        connect(Rooms.COSTUME, Direction.SOUTH, Rooms.KITCHEN);
        connect(Rooms.KITCHEN, Direction.EAST, Rooms.LIVING_ROOM);
        connect(Rooms.LIVING_ROOM, Direction.NORTH, Rooms.COMMAND);
        connect(Rooms.LIVING_ROOM, Direction.SOUTH, Rooms.EXIT_ROOM);
    }

    /**
     * Registers a room so it can be found later by its identifier.
     *
     * @param room room to register
     */
    private void add(Room room) {
        rooms.put(room.getId(), room);
    }

    /**
     * Connects two rooms in both directions.
     *
     * @param from      origin room identifier
     * @param direction direction from the origin room
     * @param to        destination room identifier
     */
    private void connect(Rooms from, Direction direction, Rooms to) {
        getRoom(from).connect(direction, to);
        getRoom(to).connect(direction.opposite(), from);
    }
}
