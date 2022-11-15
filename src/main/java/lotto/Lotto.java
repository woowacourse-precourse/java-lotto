package lotto;

import lotto.Utils.Error;
import lotto.domain.WinInfo;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;
    private WinInfo winInfo;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }
    private void checkDuplicated(List<Integer> numbers) {
        HashSet<Integer> duplicatesExcluded = new HashSet<>(numbers);
        if (duplicatesExcluded.size() != 6) {
            Error.duplicated();
        }
    }
    private void checkRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                Error.outOfRange();
            }
        }
    }
    private void validate(List<Integer> numbers) {
        checkDuplicated(numbers);
        checkRange(numbers);
    }

    public void drawLotto(List<Integer> winNumbers, int bonus) {
        int matchCount = 0;

        for (Integer number : numbers) {
            if (winNumbers.contains(number)) {
                matchCount++;
            }
        }

        winInfo = WinInfo.convert(matchCount, numbers.contains(bonus));
    }

    public WinInfo getWinInfo() {
        return winInfo;
    }

    public void print() {
        System.out.println(numbers);
    }
}
