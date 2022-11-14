package domain;

import static util.StringUtil.parseToNumbers;

public class WinningNumber {
    private final Lotto winningNumbers;

    public WinningNumber(Lotto winningNumbers){
        this.winningNumbers = winningNumbers;
    }

    public Lotto getWinningNumbers() {
        return winningNumbers;
    }
}
