package lotto.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constant.Constant;

public class Validator {

    public static boolean isInteger(String input) {
        for (int i = 0; i < input.length(); i++) {
            char needVerify = input.charAt(i);

            if (!Character.isDigit(needVerify)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isLottoPrice(int number) {
        return number % Constant.LOTTO_PRICE == 0;
    }

    public static boolean isValidSize(List<Integer> numbers) {
        return numbers.size() == Constant.LOTTO_SIZE;
    }

    public static boolean isValidNumbers(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < Constant.LOTTO_START_NUMBER || number > Constant.LOTTO_END_NUMBER) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValidNumber(int number) {
        return number >= Constant.LOTTO_START_NUMBER && number <= Constant.LOTTO_END_NUMBER;
    }

    public static boolean isUniqueNumber(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        return uniqueNumbers.size() == numbers.size();
    }
}
