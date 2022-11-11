package lotto;

public class Validator {

    public void validatePayment(String payment) {
        if (!isPositiveInteger(payment) || !isAvailablePayment(payment))
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위의 수이어야 합니다.");
    }

    public void validateWinningNumbers(String winningNumbers) {

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
