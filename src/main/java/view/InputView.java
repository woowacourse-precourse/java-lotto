package view;

import camp.nextstep.edu.missionutils.Console;
import lotto.LottoException;
import util.GameStatus;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    public String getUserInput() {
        return Console.readLine();
    }

    public int getUserAmount() {
        String userInput = getUserInput();
        numberException(userInput);
        int userAmount = Integer.parseInt(userInput);

        InputException.notDividedThousandException(userAmount);
        return userAmount;
    }

    public List<Integer> getWinningLotto() {
        String userInput = getUserInput();
        InputException.nullException(userInput);
        InputException.notFormat(userInput);
        List<String> inputList = parseStringToList(userInput);
        InputException.notLottoSize(inputList.size());
        checkEachInput(inputList);

        return getWinningNumbers(inputList);
    }

    public int getBonnusNumber() {
        String userInput = getUserInput();
        bonnusNumberException(userInput);
        return Integer.parseInt(userInput);
    }

    public void numberException(String userInput) {
        InputException.nullException(userInput);
        InputException.notNumberException(userInput);
    }

    public void bonnusNumberException(String userInput) {
        numberException(userInput);
        LottoException.notLottoNumberRangeException(userInput);
    }

    public List<String> parseStringToList(String userInput) {
        return Arrays.asList(userInput.split(GameStatus.COMMA.getCode()));
    }

    public List<Integer> getWinningNumbers(List<String> userInput) {
        return userInput.stream()
                .map(input -> Integer.parseInt(input))
                .collect(Collectors.toList());
    }

    public void checkEachInput(List<String> inputList) {
        for(String input : inputList) {
            numberException(input);
            LottoException.notLottoNumberRangeException(input);
        }
    }
}
