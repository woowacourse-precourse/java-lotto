package lotto;

import java.util.List;

import static lotto.Error.WIN_NUMBER_SIZE_ERROR;

public class WinNumber {
    private final List<Integer> winNumbers;

    public WinNumber(List<Integer> winNumbers) {
        checkSize(winNumbers);
        this.winNumbers = winNumbers;
    }

    private void checkSize(List<Integer> winNumbers) {
        if (winNumbers.size() != 6) {
            throw new IllegalArgumentException(WIN_NUMBER_SIZE_ERROR.getMessage());
        }
    }
}
