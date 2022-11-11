package lotto.bo;

import java.util.Collections;
import java.util.List;

public class WinningNumber {
    private final List<Integer> numbers;

    public WinningNumber(String winningLottoNumbers, String BonusNumber) {
        validateInteger(winningLottoNumbers);
        validateInteger(BonusNumber);
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

}
