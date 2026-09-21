package com.example.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.example.models.actions.ActionHandler;
import com.example.models.actions.ActionResult;
import com.example.models.actions.ActionType;
import com.example.models.actions.RoomAction;
import com.example.models.game.GameState;
import com.example.models.generation.GameGenerator;
import com.example.models.generation.GameRandom;
import com.example.models.map.Direction;
import com.example.models.map.Room;
import com.example.models.map.Rooms;
import com.example.utils.input.Menu;
import com.example.utils.ui.Prettier;
import com.example.utils.ui.Cleaner;

/**
 * Runs one game session.
 */
public class GameLoop {
    private static final List<ActionType> MAIN_MENU_OPTIONS = List.of(
            ActionType.NAVIGATION,
            ActionType.INVENTORY,
            ActionType.MAP,
            ActionType.INTERACTION,
            ActionType.WAIT,
            ActionType.EXIT);

    private final Cleaner cleaner = new Cleaner();

    /**
     * Executes the game loop.
     */
    public void run() {
        GameRandom random = new GameRandom(System.currentTimeMillis());
        GameState state = new GameGenerator(random).generate();
        ActionHandler actionHandler = new ActionHandler(state);
        boolean running = true;

        while (running && !state.isGameOver()) {
            cleaner.clear();
            printCurrentRoom(state);
            System.out.println();

            Menu.pause();
            ActionType actionType = readMenuOption();

            running = handleMenuShell(actionType, state, actionHandler);
        }
    }

    private void printCurrentRoom(GameState state) {
        Room currentRoom = state.getCurrentRoom();
        Prettier.printTitle("Posició actual");
        System.out.printf("%s%n", currentRoom.getName());
        System.out.printf("%s%n%n", currentRoom.getDescription());

        Prettier.printTitle("Sortides disponibles");
        for (Map.Entry<Direction, Rooms> exit : currentRoom.getConnections().entrySet()) {
            Room destination = state.getRoom(exit.getValue());
            String destinationName = destination == null ? "Sortida desconeguda" : destination.getName();
            System.out.printf("%s -> %s%n", exit.getKey().getDisplayName(), destinationName);
        }

        if (!currentRoom.getActions().isEmpty()) {
            System.out.println();
            Prettier.printTitle("Accions de la sala");
            for (RoomAction action : currentRoom.getActions()) {
                System.out.printf("- %s%n", action.getDisplayName());
            }
        }
    }

    private ActionType readMenuOption() {
        List<String> options = MAIN_MENU_OPTIONS.stream()
                .map(ActionType::getDisplayName)
                .toList();
        int option = Menu.getOption(options, "Accions");
        return MAIN_MENU_OPTIONS.get(option - 1);
    }

    private boolean handleMenuShell(ActionType actionType, GameState state, ActionHandler actionHandler) {
        return switch (actionType) {
            case NAVIGATION -> handleNavigationMenu(state);
            case INVENTORY -> handleInventoryMenu(state);
            case MAP -> handleMapMenu(state);
            case INTERACTION -> handleInteractionMenu(state, actionHandler);
            case WAIT -> {
                applyActionResult(actionHandler.handle(actionType), state);
                yield true;
            }
            case EXIT -> {
                cleaner.clear();
                Prettier.info("Sortint del joc...");
                yield false;
            }
        };
    }

    /**
     * Shows the navigation submenu and moves the player to a selected destination.
     *
     * <p>
     * The menu displays room names, but the selected option keeps the matching
     * direction so the map can still move through directional connections.
     *
     * @param state current game state
     * @return {@code true} to keep the game loop running
     */
    private boolean handleNavigationMenu(GameState state) {
        Room currentRoom = state.getCurrentRoom();
        List<Map.Entry<Direction, Rooms>> exits = new ArrayList<>(currentRoom.getConnections().entrySet());

        if (exits.isEmpty()) {
            Prettier.warn("No hi ha sortides disponibles.");
            Menu.pause();
            return true;
        }

        List<String> options = createNavigationOptions(state, exits);
        options.add("Tornar");

        int option = Menu.getOption(options, "Navegació");
        if (option == options.size()) {
            return true;
        }

        Map.Entry<Direction, Rooms> selectedExit = exits.get(option - 1);
        Room destination = state.getRoom(selectedExit.getValue());

        if (destination == null) {
            Prettier.warn("Aquesta sortida encara no està configurada.");
            Menu.pause();
            return true;
        }

        boolean success = state.move(selectedExit.getKey());

        if (success) {
            Prettier.info("Vas a: %s", destination.getName());
            state.advancePlayerTurn();
        } else {
            Prettier.warn("No pots anar a aquesta sala.");
        }

        Menu.pause();
        return success;
    }

    /**
     * Builds the labels shown in the navigation menu.
     *
     * @param state current game state used to resolve room identifiers
     * @param exits available exits from the current room
     * @return mutable option list with one label per exit
     */
    private List<String> createNavigationOptions(GameState state, List<Map.Entry<Direction, Rooms>> exits) {
        List<String> options = new ArrayList<>();

        for (Map.Entry<Direction, Rooms> exit : exits) {
            Room destination = state.getRoom(exit.getValue());
            if (destination == null) {
                options.add("Sortida desconeguda");
            } else {
                options.add(destination.getName());
            }
        }

        return options;
    }

    private boolean handleInventoryMenu(GameState state) {
        return true;
    }

    private boolean handleMapMenu(GameState state) {
        return true;
    }

    private boolean handleInteractionMenu(GameState state, ActionHandler actionHandler) {
        return true;
    }

    /**
     * Applies common consequences of action execution.
     *
     * @param result action result to apply
     * @param state  current game state
     */
    private void applyActionResult(ActionResult result, GameState state) {
        if (result.consumesTurn()) {
            state.advancePlayerTurn();
        }
    }
}
