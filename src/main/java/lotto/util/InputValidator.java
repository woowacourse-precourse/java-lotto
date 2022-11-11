package lotto.util;

import static lotto.constant.SystemMessage.BONUS_NUMBER_CONFLICT_ERROR;
import static lotto.constant.SystemMessage.PURCHASE_COST_TYPE_ERROR;
import static lotto.constant.SystemMessage.PURCHASE_COST_UNIT_ERROR;
import static lotto.constant.SystemMessage.WINNING_NUMBERS_CONFLICT_ERROR;
import static lotto.constant.SystemMessage.WINNING_NUMBERS_FORMAT_ERROR;
import static lotto.constant.SystemMessage.WINNING_NUMBERS_RANGE_ERROR;
import static lotto.constant.SystemMessage.WINNING_NUMBERS_SIZE_ERROR;
import static lotto.constant.SystemValue.LOTTERY_NUMBERS_SIZE;
import static lotto.constant.SystemValue.MAXIMUM_LOTTERY_NUMBER;
import static lotto.constant.SystemValue.MINIMUM_LOTTERY_NUMBER;

import java.util.List;
import java.util.regex.Pattern;
import lotto.view.Output;

public class InputValidator {

    public static boolean checkPurchaseCost(String purchaseCost) {
        return isTypeValid(purchaseCost) && isUnitValid(purchaseCost);
    }

    public static boolean isTypeValid(String purchaseCost) {
        boolean isType = purchaseCost.chars().allMatch(Character::isDigit);
        if (!isType) {
            Output.printError(PURCHASE_COST_TYPE_ERROR);
        }
        return isType;
    }

    public static boolean isUnitValid(String purchaseCost) {
        boolean isUnit = Integer.parseInt(purchaseCost) % 1000 == 0;
        if (!isUnit) {
            Output.printError(PURCHASE_COST_UNIT_ERROR);
        }
        return isUnit;
    }

    public static boolean checkWinningNumbers(String winningNumber) {
        return isFormatValid(winningNumber) && isSizeValid(winningNumber) && isConflictValid(winningNumber) && isRangeValid(winningNumber);
    }

    public static boolean isFormatValid(String winningNumber) {
        boolean isFormat = Pattern.matches("^[0-9,]*$", winningNumber); // TODO: ,, 도 안되게!!
        if (!isFormat) {
            Output.printError(WINNING_NUMBERS_FORMAT_ERROR);
        }
        return isFormat;
    }

    public static boolean isSizeValid(String winningNumber) {
        List<String> winningNumbers = TypeConverter.toStringListByComma(winningNumber);
        boolean isSize = winningNumbers.size() == LOTTERY_NUMBERS_SIZE;
        if (!isSize) {
            Output.printError(WINNING_NUMBERS_SIZE_ERROR);
        }
        return isSize;
    }

    public static boolean isConflictValid(String winningNumber) {
        List<Integer> winningNumbers = TypeConverter.toIntegerListByComma(winningNumber);
        boolean isConflict = winningNumbers.stream()
                .distinct()
                .count() == LOTTERY_NUMBERS_SIZE;
        if (!isConflict) {
            Output.printError(WINNING_NUMBERS_CONFLICT_ERROR);
        }
        return isConflict;
    }

    public static boolean isRangeValid(String winningNumber) {
        List<Integer> winningNumbers = TypeConverter.toIntegerListByComma(winningNumber);
        boolean isRange = winningNumbers.stream()
                .filter(number -> MINIMUM_LOTTERY_NUMBER <= number
                        && number <= MAXIMUM_LOTTERY_NUMBER)
                .count() == LOTTERY_NUMBERS_SIZE;
        if (!isRange) {
            Output.printError(WINNING_NUMBERS_RANGE_ERROR);
        }
        return isRange;
    }

    public static boolean checkBonusNumber(String bonusNumber, List<Integer> winningNumbers) {
        return isConflictWithWinningsValid(bonusNumber, winningNumbers);
    }

    public static boolean isConflictWithWinningsValid(String bonusNumber, List<Integer> winningNumbers) {
        boolean isConflictWithWinnings = winningNumbers.stream()
                .noneMatch(number -> Integer.parseInt(bonusNumber) == number);
        if (!isConflictWithWinnings) {
            Output.printError(BONUS_NUMBER_CONFLICT_ERROR);
        }
        return isConflictWithWinnings;
    }
}
