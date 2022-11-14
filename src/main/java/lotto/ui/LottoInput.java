package lotto.ui;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoInput {
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

    public List<Integer> readWinningNumber() {
        List<Integer> winningNumber;

        Messages.INPUT_LOTTE_NUMBER.printMessage();
        String userInput = readInput();

        List<String> splitInput = splitUserInput(userInput);
        inputValidator.validateInputWinningNumber(splitInput);

        winningNumber = stringListToIntegerList(splitInput);

        return winningNumber;
    }

    public int readBonusNumber(List<Integer> lottoNumber) {
        Messages.INPUT_BONUS_NUMBER.printMessage();
        String userInput = readInput();

        inputValidator.validateInputBonusNumber(userInput, lottoNumber);

        return Integer.parseInt(userInput);
    }

    public List<String> splitUserInput(String userInput) {
        List<String> splitInput = Arrays.stream(userInput.split(","))
                .collect(Collectors.toList());

        return splitInput;
    }

    public List<Integer> stringListToIntegerList(List<String> splitInput) {
        List<Integer> winningNumber = new ArrayList<>();

        for (int place = 0; place < splitInput.size(); place++) {
            winningNumber.add(place, Integer.parseInt(splitInput.get(place)));
        }

        return winningNumber;
    }
}
