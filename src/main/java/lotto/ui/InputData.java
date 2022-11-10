package lotto.ui;


import java.util.Scanner;

public class InputData {
    private static Scanner scanner;

    public String readInput() {
        scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();

        return userInput;
    }

}
