package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    public static boolean isDivide(int userPurchaseAmount, int unit) {
        if ((userPurchaseAmount % unit) == 0) {
            return true;
        }
        return false;
    }

    public static boolean isDuplicate(List<Integer> numbers) {
        Set<Integer> eliminateDuplication = new HashSet<>(numbers);
        if (numbers.size() != eliminateDuplication.size()) {
            return true;
        }
        return false;
    }

    public static boolean isOutOfRange(int number) {
        if (number < 1 || number > 45) {
            return false;
        }
        return true;
    }
}
