package lotto.ui;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Input {
    private InputValidator inputValidator = new InputValidator();

    private String readInput() {
        String userInput = Console.readLine();

        return userInput;
    }

    public int readMoney() {
        Messages.INPUT_MONEY.printMessage();
        String userInput = readInput();

        inputValidator.validateInputMoney(userInput);

        return Integer.parseInt(userInput);
    }

    public List<String> readWinningNumber() {
        Messages.INPUT_LOTTE_NUMBER.printMessage();
        String userInput = readInput();

        List<String> winningNumber = splitUserInput(userInput);
        inputValidator.validateInputWinningNumber(winningNumber);

        return winningNumber;
    }

    //예외사항 검사
    public int readBonusNumber() {
        Messages.INPUT_BONUS_NUMBER.printMessage();
        String userInput = readInput();

        return Integer.parseInt(userInput);
    }

    public List<String> splitUserInput(String userInput) {
        List<String> numbers = Arrays.stream(userInput.split(","))
                .collect(Collectors.toList());

        return numbers;
    }
}
