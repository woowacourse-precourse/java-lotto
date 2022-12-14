package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Error;

public class InputViewConsole implements InputView {
    private static final String NUMERIC_PATTERN = "^[0-9]+$";
    private static final String WINNING_NUMBERS_SEPARATOR = ",";

    @Override
    public int askPurchaseAmount() {
        String userInput = Console.readLine();
        isPurchaseAmountNumeric(userInput);
        return Integer.parseInt(userInput);
    }

    private void isPurchaseAmountNumeric(String userInput) {
        if (!userInput.matches(NUMERIC_PATTERN)) {
            throw new IllegalArgumentException(Error.PURCHASE_AMOUNT_IS_NOT_NUMERIC.getMessage());
        }
    }

    @Override
    public Integer askBonusNumber() {
        String userInput = Console.readLine();
        isStringNumeric(userInput);
        return Integer.valueOf(userInput);
    }

    private void isStringNumeric(String userInput) {
        if (!userInput.matches(NUMERIC_PATTERN)) {
            throw new IllegalArgumentException(Error.LOTTO_NUMBER_IS_NOT_NUMERIC.getMessage());
        }
    }

    @Override
    public List<Integer> askWinningNumbers() {
        String userInput = Console.readLine();
        String[] splitInputs = userInput.split(WINNING_NUMBERS_SEPARATOR);
        isWinningNumbersNumeric(splitInputs);
        return mapToIntegerList(splitInputs);
    }

    private void isWinningNumbersNumeric(String[] splitInputs) {
        for (String numString : splitInputs) {
            isStringNumeric(numString);
        }
    }

    private List<Integer> mapToIntegerList(String[] splitInput) {
        return Arrays.stream(splitInput)
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }
}
