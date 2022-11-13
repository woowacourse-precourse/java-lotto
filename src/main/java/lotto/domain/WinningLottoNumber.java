package lotto.domain;

import java.util.List;

public class WinningLottoNumber {
    private List<Integer> winningNumber;
    private Integer bonusNumber;

    public WinningLottoNumber(List<Integer> winningNumber, Integer bonusNumber) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinningNumber() {
        return winningNumber;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
