package lotto;

import java.util.List;

public class LottoCheck {
    public static int checkNumsOfMatchedNumber(List<Integer> WinningNumber, List<Integer> numbers) {
        int numsOfMatchedNumber = 0;
        for (int number : numbers) {
            if (WinningNumber.contains(number)) {
                numsOfMatchedNumber++;
            }
        }
        return numsOfMatchedNumber;
    }

    public static boolean containBonus(int bonus, List<Integer> numbers) {
        boolean contain = false;
        if (numbers.contains(bonus)) {
            contain = true;
        }
        return contain;
    }
}
