package domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static util.Constant.*;

public class InputConverter {

    public static int getMoney(String moneyInput) {
        isValidMoneyInput(moneyInput);
        return convertInput(moneyInput);
    }

    public static List<Integer> getWinningNumbers(String lottoNumbersInput) {
        String[] numbers = lottoNumbersInput.split(",");
        return Arrays.stream(numbers)
                .map(InputConverter::convertInput)
                .collect(Collectors.toList());
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
            String errorMessage = "[ERROR] 구입 금액에 숫자가 아닌 값이 포함되어 있습니다.";
            System.out.println(errorMessage);
            throw new IllegalArgumentException(errorMessage);
        }

        if (money % LOTTO_PRICE != 0) {
            String errorMessage = "[ERROR] 구입 금액은 1000원 단위로 입력되어야 합니다.";
            System.out.println(errorMessage);
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private static void isValidInRangeNumber(String numberInput) {
        int bonusNumber;
        try {
            bonusNumber = Integer.parseInt(numberInput);
        } catch (NumberFormatException e) {
            String errorMessage = "[ERROR] 보너스 숫자가 숫자가 아닌 값으로 입력되었습니다.";
            System.out.println(errorMessage);
            throw new IllegalArgumentException(errorMessage);
        }

        if (bonusNumber < MINIMUM_NUMBER || bonusNumber > MAXIMUM_NUMBER) {
            String errorMessage = "[ERROR] 보너스 숫자가 숫자가 아닌 값으로 입력되었습니다.";
            System.out.println(errorMessage);
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
