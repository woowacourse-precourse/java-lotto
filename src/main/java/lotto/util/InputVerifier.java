package lotto.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constant.Constant;
import lotto.view.View;

public class InputVerifier {

    public static void checkBonusNumber(String BonusNumber) {
        if (!isInteger(BonusNumber)) {
            View.printNotInteger();
            throw new IllegalArgumentException();
        }

        if (BonusNumber.length() != Constant.BONUS_NUMBER_SIZE) {
            View.printNotBonusNumberSize();
            throw new IllegalArgumentException();
        }

        if (!isValidNumber(BonusNumber)) {
            View.printNotLottoNumber();
            throw new IllegalArgumentException();
        }
    }

    // TODO: 쉼표로 구분했는지 검증하는 기능 구현 필요

    public static void checkMoney(String input) {
        if (!isInteger(input)) {
            View.printNotInteger();
            throw new IllegalArgumentException();
        }

        if (!isLottoPrice(input)) {
            View.printNotLottoPrice();
            throw new IllegalArgumentException();
        }
    }

    public static boolean isInteger(String input) {
        for (int i = 0; i < input.length(); i++) {
            char needVerify = input.charAt(i);

            if (!Character.isDigit(needVerify)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isLottoPrice(String input) {
        return Integer.parseInt(input) % Constant.LOTTO_PRICE == 0;
    }

    public static boolean isValidSize(List<Integer> numbers) {
        return numbers.size() == 6;
    }

    public static boolean isValidNumbers(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < Constant.LOTTO_START_NUMBER || number > Constant.LOTTO_END_NUMBER) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValidNumber(String input) {
        int number = Integer.parseInt(input);
        return number >= Constant.LOTTO_START_NUMBER && number <= Constant.LOTTO_END_NUMBER;
    }

    public static boolean isUniqueNumber(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        return uniqueNumbers.size() == numbers.size();
    }
}
