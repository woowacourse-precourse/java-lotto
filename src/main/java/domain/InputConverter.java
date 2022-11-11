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
            throw new IllegalArgumentException("[ERROR] 구입 금액에 숫자가 아닌 값이 포함되어 있습니다.");
        }

        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위로 입력되어야 합니다.");
        }
    }

    private static void isValidInRangeNumber(String numberInput) {
        int bonusNumber;
        try {
            bonusNumber = Integer.parseInt(numberInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 숫자가 숫자가 아닌 값으로 입력되었습니다.");
        }

        if (bonusNumber < MINIMUM_NUMBER || bonusNumber > MAXIMUM_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45 범위의 숫자여야 합니다.");
        }
    }
}
