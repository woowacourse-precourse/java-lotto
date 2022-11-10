package lotto.ui;


import java.io.Console;

public class InputData {
    private static Console console = System.console();

    public String readInput() {
        String userInput = console.readLine();

        return userInput;
    }
}
