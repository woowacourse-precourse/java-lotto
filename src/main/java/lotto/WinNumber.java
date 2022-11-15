package lotto;

import java.util.List;

import static lotto.Error.*;

public class WinNumber {
    private final List<Integer> winNumbers;

    public WinNumber(List<Integer> winNumbers) {
        checkSize(winNumbers);
        checkRange(winNumbers);
        this.winNumbers = winNumbers;
    }

    private void checkSize(List<Integer> winNumbers) {
        if (winNumbers.size() != 6) {
            throw new IllegalArgumentException(WIN_NUMBER_SIZE_ERROR.getMessage());
        }
    }

    private void checkRange(List<Integer> winNumbers) {
        for (Integer i : winNumbers) {
            if (i < 1 || i > 45) {
                throw new IllegalArgumentException(WIN_NUMBER_RANGE_ERROR.getMessage());
            }
        }
    }
}
