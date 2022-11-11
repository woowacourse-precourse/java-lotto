package lotto.ui;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Input {

    private String readInput() {
        String userInput = Console.readLine();

        return userInput;
    }

    private int readPurchaseAmount() {
        Messages.INPUT_MONEY.printMessage();
        String amount = readInput();

        return Integer.parseInt(amount);
    }

    //예외사항 검사
    private List<Integer> readWinningNumber() {
        Messages.INPUT_LOTTE_NUMBER.printMessage();
        String userInput = readInput();

        List<Integer> numbers = Arrays.stream(userInput.split(","))
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());

        return numbers;
    }

    //예외사항 검사
    private int readBonusNumber() {
        Messages.INPUT_BONUS_NUMBER.printMessage();
        String userInput = readInput();

        return Integer.parseInt(userInput);
    }
}
