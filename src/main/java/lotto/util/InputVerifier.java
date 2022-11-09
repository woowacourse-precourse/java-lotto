package lotto.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constant.Constant;

public class InputVerifier {

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
        int number = Integer.parseInt(input);
        return number % Constant.LOTTO_PRICE == 0;
    }

    // TODO: 쉼표로 구분했는지 검증하는 기능 구현 필요

    public static boolean isValidSize(List<String> input) {
        return input.size() == 6;
    }

    public static boolean isValidNumber(List<String> input) {
        for (String i : input) {
            int number = Integer.parseInt(i);

            if (number < Constant.LOTTO_START_NUMBER || number > Constant.LOTTO_END_NUMBER) {
                return false;
            }
        }
        return true;
    }

    public static boolean isUniqueNumber(List<String> input) {
        Set<String> uniqueInput = new HashSet<>(input);
        return uniqueInput.size() == input.size();
    }

}
