package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.Error.*;

public class WinNumber {
    public List<Integer> winNumbers;

    public WinNumber(List<Integer> winNumbers) {
        checkSize(winNumbers);
        checkRange(winNumbers);
        checkDuplicated(winNumbers);
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

    private void checkDuplicated(List<Integer> winNumbers) {
        Set<Integer> set = new HashSet<>(winNumbers);
        if (set.size() != winNumbers.size()) {
            throw new IllegalArgumentException(WIN_NUMBER_DUPLICATED_ERROR.getMessage());
        }
    }
}
