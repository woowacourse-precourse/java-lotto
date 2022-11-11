package lotto.bo;

import java.util.Collections;
import java.util.List;

public class WinningNumber {
    private final List<Integer> numbers;

    public WinningNumber(String winningLottoNumbers, String BonusNumber) {
        validateInteger(winningLottoNumbers);
        validateInteger(BonusNumber);
        validateRange(winningLottoNumbers);
        validateRange(BonusNumber);
        this.numbers = Collections.emptyList();
    }

    private void validateInteger(String numbers) {
        for (String number : numbers.split(",")) {
            try {
                Integer.valueOf(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자가 아닙니다");
            }
        }
    }

    private void validateRange(String numbers) {
        for (String number : numbers.split(",")) {
            if (Integer.valueOf(number) < 1 || Integer.valueOf(number) > 45) {
                throw new IllegalArgumentException("당첨 번호와 보너스 번호는 1~ 45 사이의 숫자이어야합니다.");
            }
        }
    }
}
