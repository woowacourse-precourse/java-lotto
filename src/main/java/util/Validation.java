package util;

import static util.Constant.*;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Validation {

    // 구입 금액이 1000의 배수인지 검증하는 기능
    public static void validatePurchaseMoney(String money) {
        if(Integer.parseInt(money) % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000의 배수여야 합니다.");
        }
    }

    // 당첨 번호에 ,와 숫자로만 구성되었는지 검증하는 기능
    public static void validateWinningNumberContainCommaAndNum(String winningNumber) {
        if (!winningNumber.matches(WINNING_NUMBER_REGEX)) {
            throw  new IllegalArgumentException("[ERROR] 당첨 번호는 숫자와 ,로만 구셩되어야 합니다.");
        }
    }

    // 당첨 번호에 ,가 처음과 끝에 없는지 검증하는 기능
    public static void validateWinningNumberStartOrEndWithComma(String winningNumber) {
        if (winningNumber.startsWith(COMMA) || winningNumber.endsWith(COMMA)) {
            throw new IllegalArgumentException("[ERROR] 콤마는 처음과 끝이면 안됩니다.");
        }
    }
}
