package lotto.domain;

import java.util.List;

public class WinningLotto {
    private final List<Integer> winningNumbers;
    private final int bounsNumber;

    public WinningLotto(List<Integer> winningNumbers, int bounsNumber) {
        this.winningNumbers = winningNumbers;
        this.bounsNumber = bounsNumber;
    }
}
