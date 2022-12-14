package lotto.domain;

import java.util.List;

public class WinningNumber {
    private final Lotto winningNumber;

    public WinningNumber(final List<Integer> winningNumber) {
        this.winningNumber = new Lotto(winningNumber);
    }
}
