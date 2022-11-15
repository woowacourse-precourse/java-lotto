package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.resource.message.ExceptionMessage;
import lotto.resource.message.FixedMessage;

public class InputView {
    private static final String COMMA = ",";

    public Integer askPrice() {
        System.out.println(FixedMessage.INPUT_PRICE.getMessage());
        return validateValue(Console.readLine());
    }

    public List<Integer> askWinningNumbers() {
        System.out.println("\n" + FixedMessage.INPUT_WINNING_NUMBERS.getMessage());
        return getWinningNumbers(Console.readLine());
    }

    private List<Integer> getWinningNumbers(String inputValue) {
        List<Integer> winningNumbers = new ArrayList<>();
        for (String splitValue : inputValue.split(COMMA)) {
            winningNumbers.add(validateValue(splitValue));
        }
        return winningNumbers;
    }

    public Integer askBonusNumber() {
        System.out.println("\n" + FixedMessage.INPUT_BONUS_NUMBER.getMessage());
        return validateValue(Console.readLine());
    }

    public Integer validateValue(String inputValue) {
        if (!isNumber(inputValue)) {
            System.out.println(ExceptionMessage.NON_NUMERIC_VALUE.getMessage());
            throw new IllegalArgumentException();
        }
        return Integer.valueOf(inputValue);
    }

    private boolean isNumber(String inputValue) {
        return inputValue.chars().allMatch(Character::isDigit);
    }
}
