package lotto.domain.vo;

import java.util.List;

public class LottoInfo {
    private final List<Integer> winningNumber;
    private final int bonusNumber;

    public LottoInfo(List<Integer> winningNumber, int bonusNumber) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinningNumber() {
        return winningNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
