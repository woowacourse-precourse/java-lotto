package lotto.ui;


import java.util.List;
import java.util.Scanner;

public class InputData {
    private static Scanner scanner = new Scanner(System.in);

    private String readInput() {
        String userInput = scanner.nextLine();

        return userInput;
    }

    private String readPurchaseAmount() {
        System.out.println(Messages.INPUT_MONEY.getMessage());
        String amount = scanner.nextLine();

        return amount;
    }

    //예외사항 검사
    private List<String> readWinningNumber() {
        System.out.println(Messages.INPUT_LOTTE_NUMBER.getMessage());
        String userInput = readInput();

        List<String> winningNumber = List.of(userInput.split(","));

        return winningNumber;
    }

    //예외사항 검사
    private String readBonusNumber() {
        System.out.println(Messages.INPUT_BONUS_NUMBER);
        String userInput = readInput();

        return userInput;
    }
}
