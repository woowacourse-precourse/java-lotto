package lotto.exception;

import java.util.List;

public class IllegalArgument {

    public static boolean isNumber(String purchaseAmount) {
        if (!purchaseAmount.matches("[0-9]+")) {
            return false;
        }
        return true;
    }

    public static boolean isThousandWon(String purchaseAmount) {
        if (Integer.parseInt(purchaseAmount) % 1000 != 0) {
            return false;
        }
        return true;
    }

    public static boolean isInRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                return false;
            }
        }
        return true;
    }
}
