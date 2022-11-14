package lotto.repository;

import lotto.domain.WinningNumber;

public class WinningNumberRepository {

    private static WinningNumber winningNumber;

    public WinningNumber save(WinningNumber winningNumber) {
        this.winningNumber = winningNumber;
        return winningNumber;
    }

    public WinningNumber findWinningNumber() {
        return winningNumber;
    }
}
