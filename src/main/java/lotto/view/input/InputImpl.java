package lotto.view.input;


import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

import static lotto.utils.ErrorMessage.INVALID_BONUS_NUMBER;
import static lotto.utils.ErrorMessage.INVALID_MONEY_UNIT;
import static lotto.utils.ErrorMessage.INVALID_WINNING_NUMBERS;

public class InputImpl implements Input {

    private static final String MONEY_PATTERN = "^([1-9])(\\d*)(0{3})$";
    private static final String WINNING_NUMBERS_PATTERN = "^(([1-9]|[1-3]\\d|4[0-5]),){5}([1-9]|[1-3]\\d|4[0-5])$";
    private static final String BONUS_NUMBER_PATTERN = "^[1-9]|[1-3]\\d|4[0-5]$";

    @Override
    public String moneyInput() {
        String userInput = Console.readLine();
        validateMoneyInput(userInput);
        return userInput;
    }

    @Override
    public String winningNumbersInput() {
        String systemInput = Console.readLine();
        validateWinningNumbersInput(systemInput);
        return systemInput;
    }

    @Override
    public String BonusNumberInput() {
        String systemInput = Console.readLine();
        validateBonusNumberInput(systemInput);
        return systemInput;
    }

    private void validateMoneyInput(String userInput) {
        if (!Pattern.matches(MONEY_PATTERN, userInput)) {
            throw new IllegalArgumentException(INVALID_MONEY_UNIT.message);
        }
    }

    private void validateWinningNumbersInput(String systemInput) {
        if (!Pattern.matches(WINNING_NUMBERS_PATTERN, systemInput)) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBERS.message);
        }
    }

    private void validateBonusNumberInput(String systemInput) {
        if (!Pattern.matches(BONUS_NUMBER_PATTERN, systemInput)) {
            throw new IllegalArgumentException(INVALID_BONUS_NUMBER.message);
        }
    }
}
