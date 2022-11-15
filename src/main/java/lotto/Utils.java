package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Utils {

    public static int convertStringToInt(String input) {
        int number;

        try {
            number = Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(String.valueOf(ErrorCode.INPUT_NOT_NUMBER));
        }
        return number;
    }

    public static String readMoney() {
        String money = Console.readLine();
        return money;
    }

    public static String readWinNumbers() {
        String winNumbers = Console.readLine();
        return winNumbers;
    }

    public static String readBonusNumber() {
        String bonusNumber = Console.readLine();
        return bonusNumber;
    }

    public static void validateNumber(List<Integer> numbers, int numIdx) {
        if (numbers.indexOf(numbers.get(numIdx)) != numIdx) {
            throw new IllegalArgumentException(String.valueOf(ErrorCode.NOT_UNIQUE_NUMBERS));
        }
    }

    public static void isUniqueNumbers(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            validateNumber(numbers, i);
        }
    }

}
