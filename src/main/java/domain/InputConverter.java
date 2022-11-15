package domain;

import java.util.ArrayList;
import java.util.List;

import static util.Constant.*;

// 사용자가 입력하는 값을 원하는 자료형으로 바꾸는 기능을 담당하는 클래스
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
        int money = getInputAsInt(moneyInput, NOT_NUMERAL_MONEY_INPUT);
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(NOT_VALID_MONEY_UNIT);
        }
    }

    private static void isValidInRangeNumber(String numberInput) {
        int bonusNumber = getInputAsInt(numberInput, NOT_NUMERAL_NUMBER_INPUT);
        if (bonusNumber < MINIMUM_NUMBER || bonusNumber > MAXIMUM_NUMBER) {
            throw new IllegalArgumentException(NOT_IN_RANGE_NUMBER_INPUT);
        }
    }

    private static int getInputAsInt(String input, String errorMessage) {
        int inputAsInt;
        try {
            inputAsInt = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(errorMessage);
        }
        return inputAsInt;
    }
}
