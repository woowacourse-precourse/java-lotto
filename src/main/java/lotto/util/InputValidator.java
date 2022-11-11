package lotto.util;

import static lotto.constant.SystemMessage.PURCHASE_COST_TYPE_ERROR;
import static lotto.constant.SystemMessage.PURCHASE_COST_UNIT_ERROR;
import static lotto.constant.SystemMessage.WINNING_NUMBERS_RANGE_ERROR;
import static lotto.constant.SystemMessage.WINNING_NUMBERS_SIZE_ERROR;
import static lotto.constant.SystemValue.LOTTERY_NUMBERS_SIZE;
import static lotto.constant.SystemValue.MAXIMUM_LOTTERY_NUMBER;
import static lotto.constant.SystemValue.MINIMUM_LOTTERY_NUMBER;

import java.util.List;
import lotto.view.Output;

public class InputValidator {

    public static boolean checkPurchaseCost(String purchaseCost) {
        return isTypeValid(purchaseCost) && isUnitValid(purchaseCost);
    }

    public static boolean isTypeValid(String purchaseCost) {
        boolean isTypeValid = purchaseCost.chars().allMatch(Character::isDigit);
        if (!isTypeValid) {
            Output.printError(PURCHASE_COST_TYPE_ERROR);
        }
        return isTypeValid;
    }

    public static boolean isUnitValid(String purchaseCost) {
        boolean isUnitValid = Integer.parseInt(purchaseCost) % 1000 == 0;
        if (!isUnitValid) {
            Output.printError(PURCHASE_COST_UNIT_ERROR);
        }
        return isUnitValid;
    }

    public static boolean checkWinningNumbers(List<Integer> winningNumbers) {
        return isSizeValid(winningNumbers) && isRangeValid(winningNumbers);
    }

    public static boolean isSizeValid(List<Integer> winningNumbers) {
        boolean isSizeValid = winningNumbers.size() == LOTTERY_NUMBERS_SIZE;
        if (!isSizeValid) {
            Output.printError(WINNING_NUMBERS_SIZE_ERROR);
        }
        return isSizeValid;
    }

    public static boolean isRangeValid(List<Integer> winningNumbers) {
        boolean isRangeValid = winningNumbers.stream()
                .filter(winningNumber -> MINIMUM_LOTTERY_NUMBER <= winningNumber
                        && winningNumber <= MAXIMUM_LOTTERY_NUMBER)
                .count() == LOTTERY_NUMBERS_SIZE;
        if (!isRangeValid) {
            Output.printError(WINNING_NUMBERS_RANGE_ERROR);
        }
        return isRangeValid;
    }
}
