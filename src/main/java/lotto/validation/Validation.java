package lotto.validation;

import static lotto.util.Constant.*;

import java.util.Arrays;

public class Validation {

    // 구입 금액이 1000의 배수인지 검증하는 기능
    public static void validatePurchaseMoney(String money) {
        if (Integer.parseInt(money) % LOTTO_PURCHASE_COST != ZERO) {
            throw new IllegalArgumentException(ERROR_MSG_PURCHASE_MONEY);
        }
    }

    // 구입 금액이 숫자로 구성되었는지 검증 기능
    public static void validatePurchaseMoneyConsistOfNum(String money) {
        if (!money.matches(LOTTO_PURCHASE_REGEX)) {
            throw new IllegalArgumentException(ERROR_MSG_PURCHASE_MONEY_CONSIST_OF_NUM);
        }
    }

    // 구입 금액이 1000원보다 큰지 검증하는 기능
    public static void validatePurchaseMoneyGreaterThan1000(String money) {
        if (!(Integer.parseInt(money) >= LOTTO_PURCHASE_COST)) {
            throw new IllegalArgumentException(ERROR_MSG_PURCHASE_MONEY_LESS_THAN_1000);
        }
    }

    // 당첨 번호에 ,와 숫자로만 구성되었는지 검증하는 기능
    public static void validateWinningNumberContainCommaAndNum(String winningNumber) {
        if (!winningNumber.matches(WINNING_NUMBER_REGEX)) {
            throw new IllegalArgumentException(ERROR_MSG_INVALID_INPUT);
        }
        if (!winningNumber.contains(",")){
            throw new IllegalArgumentException(ERROR_MSG_WINNING_LOTTO_CONTAIN_COMMA);
        }
    }

    // 당첨 번호를 ,로 분리할 시 숫자만 포함되어있는지 검증
    public static void validateWinningNumberSplitCommaConsistOfNum(String winningNumber){
        boolean numberOnly = Arrays.stream(winningNumber.split(COMMA))
            .allMatch(s -> s.matches(NUMBER_REGEX));
        if(!numberOnly || winningNumber.contains(CONTINUOUS_COMMA)){
            throw new IllegalArgumentException(ERROR_MSG_WINNING_LOTTO_CONTAIN_NUM);
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
