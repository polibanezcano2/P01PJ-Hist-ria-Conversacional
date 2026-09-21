package com.example;

import com.example.controllers.GameController;

/**
 * Application entry point.
 */
public class App {
    /**
     * Starts the application.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        App app = new App();
        app.run();
    }

    /**
     * Runs the application workflow.
     */
    public void run() {
        GameController.startGame();
    }
}
