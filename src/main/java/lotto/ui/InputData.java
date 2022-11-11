package lotto.ui;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputData {

    private String readInput() {
        String userInput = Console.readLine();

        return userInput;
    }

    private int readPurchaseAmount() {
        System.out.println(Messages.INPUT_MONEY.getMessage());
        String amount = readInput();

        return Integer.parseInt(amount);
    }

    //예외사항 검사
    private List<Integer> readWinningNumber() {
        System.out.println(Messages.INPUT_LOTTE_NUMBER.getMessage());
        String userInput = readInput();

        List<Integer> numbers = Arrays.stream(userInput.split(","))
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());

        return numbers;
    }

    //예외사항 검사
    private int readBonusNumber() {
        System.out.println(Messages.INPUT_BONUS_NUMBER);
        String userInput = readInput();

        return Integer.parseInt(userInput);
    }
}
