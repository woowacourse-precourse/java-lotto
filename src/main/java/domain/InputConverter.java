package domain;

import ui.SystemMessage;

import java.util.ArrayList;
import java.util.List;

import static util.Constant.*;

public class InputConverter {

    public static int getMoney(String moneyInput) {
        isValidMoneyInput(moneyInput);
        return convertInput(moneyInput);
    }

    public static List<Integer> getWinningNumbers(String lottoNumbersInput) {
        String[] numbers = lottoNumbersInput.split(",");
        List<Integer> winningNumbers = new ArrayList<>();
        for (String number : numbers) {
            isValidInRangeNumber(number);
            winningNumbers.add(InputConverter.getNumber(number));
        }
        return winningNumbers;
    }

    public static int getNumber(String number) {
        isValidInRangeNumber(number);
        return convertInput(number);
    }

    private static int convertInput(String input) {
        return Integer.parseInt(input);
    }

    private static void isValidMoneyInput(String moneyInput) {
        int money;
        try {
            money = Integer.parseInt(moneyInput);
        } catch (NumberFormatException e) {
            SystemMessage.printErrorMessage(NOT_NUMERAL_MONEY_INPUT);
            throw new IllegalArgumentException(NOT_NUMERAL_MONEY_INPUT);
        }

        if (money % LOTTO_PRICE != 0) {
            SystemMessage.printErrorMessage(NOT_VALID_MONEY_UNIT);
            throw new IllegalArgumentException(NOT_VALID_MONEY_UNIT);
        }
    }

    private static void isValidInRangeNumber(String numberInput) {
        int bonusNumber;
        try {
            bonusNumber = Integer.parseInt(numberInput);
        } catch (NumberFormatException e) {
            SystemMessage.printErrorMessage(NOT_NUMERAL_NUMBER_INPUT);
            throw new IllegalArgumentException(NOT_NUMERAL_NUMBER_INPUT);
        }

        if (bonusNumber < MINIMUM_NUMBER || bonusNumber > MAXIMUM_NUMBER) {
            SystemMessage.printErrorMessage(NOT_IN_RANGE_NUMBER_INPUT);
            throw new IllegalArgumentException(NOT_IN_RANGE_NUMBER_INPUT);
        }
    }
}
