package lotto;

import java.util.List;

public class Validator {

    public void validatePayment(String payment) {
        if (!isPositiveInteger(payment) || !isAvailablePayment(payment))
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위의 수이어야 합니다.");
    }

    public void validateWinningNumbers(String winningNumbers) {
        // 형태를 검증한다.
        // 숫자들을 검증한다.
    }

    private void validateFormOfWinningNumbers(String winningNumbers) {
        if (!winningNumbers.matches("[1-9][0-9]*,[1-9][0-9]*,[1-9][0-9]*,[1-9][0-9]*,[1-9][0-9]*,[1-9][0-9]*")) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호들의 형태가 잘못되었습니다.");
        }
    }

    private void validateValuesOfWinningNumbers(List<Integer> winningNumbers) {
        // 숫자들은 1과 45 사이의 중복되지 않는 6개의 수이다.
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
