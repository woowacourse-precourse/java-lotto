package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WinningLotto {
    private static final int COUNT_LOTTO_NUMBER = 6;

    private final List<Integer> winningNumbers;
    private int bonusball;

    public WinningLotto(List<String> numbers, String bonusball) {
        winningNumbers = numbers.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        this.bonusball = Integer.parseInt(bonusball);
    }

    public List<Integer> getNumbers() {
        return winningNumbers;
    }

    public int getBonusball() {
        return bonusball;
    }
}
