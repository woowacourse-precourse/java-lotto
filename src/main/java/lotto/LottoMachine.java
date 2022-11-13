package lotto;

import java.util.List;

public class LottoMachine {
    private final List<Integer> winningNumbers;
    private final int bonusNumbers;

    public LottoMachine(List<Integer> winningNumbers, int bonusNumbers) {
        this.winningNumbers = winningNumbers;
        this.bonusNumbers = bonusNumbers;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumbers() {
        return bonusNumbers;
    }
}
