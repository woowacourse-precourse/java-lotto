package lotto;

import java.util.List;

public class Validator {

    public void validateAmountOfPurchaseMoney(String amountOfPurchaseMoney) {
        if (!isPositiveInteger(amountOfPurchaseMoney) || !isAvailablePayment(amountOfPurchaseMoney))
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위의 수이어야 합니다.");
    }

    public void validateWinningNumbers(List<Integer> winningNumbers) {

    }

    public void validateBonusNumber(int bonusNumber) {

    }

    private boolean isPositiveInteger(String string) {
        return string.matches("[1-9][0-9]+");
    }

    private boolean isAvailablePayment(String payment) {
        return Integer.parseInt(payment) % 1000 == 0;
    }
}
