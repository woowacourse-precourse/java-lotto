package lotto;

import java.util.List;

public class Validator {

    public void validateAmountOfPurchaseMoney(String amountOfPurchaseMoney) {

    }

    public void validateWinningNumbers(List<Integer> winningNumbers) {

    }

    public void validateBonusNumber(int bonusNumber) {

    }

    private boolean isNumberNotZeroOrLess(String string) {
        return string.matches("[1-9][0-9]+");
    }

    private boolean isAvailablePayment(String payment) {
        return false;
    }
}
