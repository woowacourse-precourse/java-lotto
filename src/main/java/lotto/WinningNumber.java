package lotto;

import java.util.List;

import static lotto.constant.Constants.*;

public class WinningNumber {

    Lotto lotto;
    int bonusNumber;

    private void inputWinningNumber() {

    }

    private void validateForRange(List<Integer> WinningNumber) {
        if (!WinningNumber.stream().allMatch(num -> num >= MIN_LOTTO_NUMBER && num <= MAX_LOTTO_NUMBER)) {
            throw new IllegalArgumentException(OUT_OF_RANGE_ERROR_MESSAGE);
        }
    }
}
