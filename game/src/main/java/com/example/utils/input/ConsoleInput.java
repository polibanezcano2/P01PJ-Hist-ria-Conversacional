package com.example.utils.input;

import java.util.Scanner;

/**
 * Shared console input stream for every input helper.
 */
final class ConsoleInput {
    private static final Scanner SCANNER = new Scanner(System.in);

    private ConsoleInput() {
        throw new UnsupportedOperationException("Utility class");
    }

    static Scanner scanner() {
        return SCANNER;
    }
}
