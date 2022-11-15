package util.validation;

import lotto.Lotto;

public class ValidationUtil {
    public static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }

    public static boolean isUnitsOf1000Won(String purchasePrice) {
        return Integer.parseInt(purchasePrice) % 1000 == 0;
    }
}
