package lotto.management;

import lotto.exception.LottoWinningNumber;

import java.util.List;

public class WinningNumber {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    WinningNumber(List<Integer> winningNumbers, int bonusNumber) {
        LottoWinningNumber lottoWinningNumber = new LottoWinningNumber(winningNumbers, bonusNumber);
        this.winningNumbers = lottoWinningNumber.getWinningNumbers();
        this.bonusNumber = lottoWinningNumber.getBonusNumber();
    }

    public List<Integer> getWinningNumbers(){
        return winningNumbers;
    }
    public int getBonusNumber(){
        return bonusNumber;
    }
}
