package util;

import static util.Constant.*;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Validation {

    // 구입 금액이 1000의 배수인지 검증하는 기능
    public static void validatePurchaseMoney(String money) {
        if (Integer.parseInt(money) % 1000 != 0) {
            throw new IllegalArgumentException(ERROR_MSG_PURCHASE_MONEY);
        }
    }

    // 구입 금액이 숫자로 구성되었는지 검증 기능
    public static void validatePurchaseMoneyConsistOfNum(String money) {
        if (!money.matches(NUMBER_REGEX)) {
            throw new IllegalArgumentException(ERROR_MSG_PURCHASE_MONEY_CONSIST_OF_NUM);
        }
    }

    // 당첨 번호에 ,와 숫자로만 구성되었는지 검증하는 기능
    public static void validateWinningNumberContainCommaAndNum(String winningNumber) {
        if (!winningNumber.matches(WINNING_NUMBER_REGEX)) {
            throw new IllegalArgumentException(ERROR_MSG_INVALID_INPUT);
        }
    }

    // 당첨 번호에 ,가 처음과 끝에 없는지 검증하는 기능
    public static void validateWinningNumberStartOrEndWithComma(String winningNumber) {
        if (winningNumber.startsWith(COMMA) || winningNumber.endsWith(COMMA)) {
            throw new IllegalArgumentException(ERROR_MSG_START_OR_END_COMMA);
        }
    }

    // 보너스 번호가 숫자로 구성되어있는지 검증하는 기능
    public static void validateBonusNumberConsistOfNum(String bonusNumber) {
        if (!bonusNumber.matches(NUMBER_REGEX)) {
            throw new IllegalArgumentException(ERROR_MSG_NOT_NUMBER);
        }
    }
}
