package lotto.exception;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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

    public static boolean isRedundancy(List<Integer> numbers) {
        numbers = numbers.stream().distinct().collect(Collectors.toList());
        if (numbers.size() != 6) {
            return true;
        }
        return false;
    }

    public static boolean isRedundancyWithNumbers(int bonusNumber, List<Integer> numbers) {
        for (int number : numbers) {
            if (number == bonusNumber) {
                return true;
            }
        }
        return false;
    }
}
