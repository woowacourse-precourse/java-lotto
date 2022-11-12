package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Validator {

    public void validatePayment(String payment) {
        if (!isPositiveInteger(payment) || !isAvailablePayment(payment))
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위의 수이어야 합니다.");
    }

    private boolean isPositiveInteger(String string) {
        return string.matches("[1-9][0-9]+");
    }

    private boolean isAvailablePayment(String payment) {
        return Integer.parseInt(payment) % 1000 == 0;
    }

    public void validateWinningNumbers(String winningNumbers) {
        validateFormOfWinningNumbers(winningNumbers);
        validateValuesOfWinningNumbers(Arrays.stream(winningNumbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList()));
    }

    private void validateFormOfWinningNumbers(String winningNumbers) {
        if (!winningNumbers.matches("[1-9][0-9]*,[1-9][0-9]*,[1-9][0-9]*,[1-9][0-9]*,[1-9][0-9]*,[1-9][0-9]*")) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호들의 형태가 잘못되었습니다.");
        }
    }

    private void validateValuesOfWinningNumbers(List<Integer> winningNumbers) {
        Set<Integer> collection = winningNumbers.stream()
                .filter(number -> 1 <= number && number <= 45)
                .collect(Collectors.toSet());
        if (collection.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호들의 값이 잘못되었습니다.");
        }
    }

    public void validateBonusNumber(String bonusNumber, List<Integer> winningNumbers) {

    }

    private void bonusNumberIsValidNumber(String bonusNumber) {
        if (!bonusNumber.matches("[1-9][0-9]*") && !(Integer.parseInt(bonusNumber) <= 45)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호 입력이 잘못되었습니다.");
        }
    }

    private void bonusNumberIsNotDuplicated(int bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 당첨 번호와 중복되었습니다.");
        }
    }
}
