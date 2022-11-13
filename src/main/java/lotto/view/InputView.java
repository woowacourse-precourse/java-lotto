package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.view.message.ExceptionMessage;
import lotto.view.message.FixedMessage;

public class InputView {
    private static final String COMMA = ",";

    public Integer askPrice() {
        System.out.println(FixedMessage.INPUT_PRICE.getMessage());
        String inputValue = Console.readLine();
        return validateValue(inputValue);
    }

    public List<Integer> askWinningNumbers() {
        System.out.println(FixedMessage.INPUT_WINNING_NUMBERS.getMessage());
        String inputValue = Console.readLine();
        return getWinningNumbers(inputValue);
    }

    private List<Integer> getWinningNumbers(String inputValue) {
        List<Integer> winningNumbers = new ArrayList<>();
        for (String splitValue : inputValue.split(COMMA)) {
            winningNumbers.add(validateValue(splitValue));
        }
        return winningNumbers;
    }

    public Integer askBonusNumber() {
        System.out.println(FixedMessage.INPUT_BONUS_NUMBER.getMessage());
        String inputValue = Console.readLine();
        return validateValue(inputValue);
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
