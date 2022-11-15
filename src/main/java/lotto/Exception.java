package lotto;

import static lotto.Constants.COUNT_NUM;
import static lotto.Constants.ERROR;
import static lotto.Constants.UNIT;

import java.util.List;

public class Exception {
    public static void validatePurchaseAmount(String purchaseAmount) {
        int userPurchaseAmount;
        try {
            userPurchaseAmount = Integer.parseInt(purchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR + "구입금액을 숫자로 입력해주세요");
        }
        if (!Validator.isDivide(userPurchaseAmount, UNIT)) {
            throw new IllegalArgumentException(ERROR + UNIT + "원 단위로 구입이 가능합니다");
        }
    }
    public static void validateWinningNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.size() != COUNT_NUM) {
            throw new IllegalArgumentException(ERROR + "당첨 번호 숫자는 6개입니다");
        }
        if (Validator.isDuplicate(winningNumbers)) {
            throw new IllegalArgumentException(ERROR + "당첨 번호에 중복된 숫자가 있습니다");
        }
    }

    public static void validateBonusNumber(String bonusNumber) {
        if (bonusNumber.length() != 1) {
            throw new IllegalArgumentException(ERROR + "보너스 번호는 1개입니다");
        }
        if (Validator.isOutOfRange(Integer.parseInt(bonusNumber))) {
            throw new IllegalArgumentException(ERROR + "보너스 번호가 범위를 벗어났습니다");
        }
    }

}
