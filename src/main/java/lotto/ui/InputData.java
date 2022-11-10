package lotto.ui;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputData {
    private static Scanner scanner = new Scanner(System.in);

    public String readInput() {
        String userInput = scanner.nextLine();

        return userInput;
    }

    public int readPurchaseAmount() {
        System.out.println(Messages.INPUT_MONEY.getMessage());
        int amount = Integer.parseInt(scanner.nextLine());

        return amount;
    }


    
}
