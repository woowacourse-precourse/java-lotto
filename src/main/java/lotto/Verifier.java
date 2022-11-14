package lotto;

import java.util.ArrayList;
import java.util.List;

public class Verifier {
    public static boolean isValidMoney(String value) {
        if (!isInteger(value)) {
            return false;
        }
        int money = Integer.parseInt(value);
        if (money < Lotto.PRICE) {
            return false;
        }
        if ((money % Lotto.PRICE) != 0) {
            return false;
        }
        return true;
    }

    public static boolean isValidWinningNumbers(String[] values) {
        if (values.length != Lotto.NUMBER_COUNT) {
            return false;
        }
        if (hasDuplicate(values)) {
            return false;
        }
        for (String value : values) {
            if (!isValidNumber(value)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValidNumber(String value) {
        if (!isInteger(value)) {
            return false;
        }
        int number = Integer.parseInt(value);
        if (number < Lotto.START_RANGE || number > Lotto.END_RANGE) {
            return false;
        }
        return true;
    }

    public static boolean hasDuplicate(String[] values) {
        List<String> temp = new ArrayList<>();
        for (String value : values) {
            if (temp.contains(value)) {
                return true;
            }
            temp.add(value);
        }
        return false;
    }

    public static boolean isInteger(String value) {
        return value.matches("[+-]?\\d+");
    }
}
