package lotto.util;

import static lotto.constant.SystemValue.LOTTERY_NUMBERS_SIZE;
import static lotto.constant.SystemValue.MAXIMUM_LOTTERY_NUMBER;
import static lotto.constant.SystemValue.MINIMUM_LOTTERY_NUMBER;

import java.util.List;

public class InputValidator {

    public static boolean checkPurchaseCost(int purchaseCost) {
        return isUnitValid(purchaseCost);
    }

    public static boolean isUnitValid(int purchaseCost) {
        return purchaseCost % 1000 == 0;
    }

    public static boolean checkWinningNumbers(List<Integer> winningNumbers) {
        return isSizeValid(winningNumbers) && isRangeValid(winningNumbers);
    }

    public static boolean isSizeValid(List<Integer> winningNumbers) {
        return winningNumbers.size() == LOTTERY_NUMBERS_SIZE;
    }

    public static boolean isRangeValid(List<Integer> winningNumbers) {
        return winningNumbers.stream()
                .filter(winningNumber -> MINIMUM_LOTTERY_NUMBER <= winningNumber
                        && winningNumber <= MAXIMUM_LOTTERY_NUMBER)
                .count() == LOTTERY_NUMBERS_SIZE;
    }
}
