package com.example.controllers;

import java.util.List;
import java.util.Map;

import com.example.models.actions.ActionHandler;
import com.example.models.actions.ActionType;
import com.example.models.actions.RoomAction;
import com.example.models.game.GameState;
import com.example.models.generation.GameGenerator;
import com.example.models.generation.GameRandom;
import com.example.models.map.Direction;
import com.example.models.map.Room;
import com.example.models.map.RoomFeature;
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

        while (running && !state.isFinished()) {
            cleaner.clear();
            printCurrentRoom(state);
            System.out.println();

            Menu.pause();
            ActionType actionType = readMenuOption();
            actionHandler.handle(actionType);

            running = handleMenuShell(actionType);
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
            System.out.printf("%s -> %s%n", exit.getKey().getDisplayName(), destination.getName());
        }

        if (!currentRoom.getFeatures().isEmpty()) {
            System.out.println();
            Prettier.printTitle("Llocs interactius");
            for (RoomFeature feature : currentRoom.getFeatures()) {
                System.out.printf("%s: %s%n", feature.getName(), feature.getDescription());
            }
        }

        if (!currentRoom.getActions().isEmpty()) {
            System.out.println();
            Prettier.printTitle("Accions de la sala");
            for (RoomAction action : currentRoom.getActions()) {
                if (action.hasFeature()) {
                    System.out.printf("- %s (%s)%n", action.getDisplayName(), action.getFeature().getName());
                } else {
                    System.out.printf("- %s%n", action.getDisplayName());
                }
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

    private boolean handleMenuShell(ActionType actionType) {
        return switch (actionType) {
            case NAVIGATION -> handleNavigationMenu();
            case INVENTORY -> handleInventoryMenu();
            case MAP -> handleMapMenu();
            case INTERACTION -> handleInteractionMenu();
            case WAIT -> true;
            case EXIT -> {
                cleaner.clear();
                Prettier.info("Sortint del joc...");
                yield false;
            }
        };
    }

    private boolean handleNavigationMenu() {
        return true;
    }

    private boolean handleInventoryMenu() {
        return true;
    }

    private boolean handleMapMenu() {
        return true;
    }

    private boolean handleInteractionMenu() {
        return true;
    }
}
