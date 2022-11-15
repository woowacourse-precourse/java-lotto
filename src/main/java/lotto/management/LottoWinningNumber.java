package lotto.management;

import lotto.exception.WinningNumber;

import java.util.List;

public class LottoWinningNumber {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    LottoWinningNumber(List<Integer> winningNumbers, int bonusNumber) {
        WinningNumber winningNumber = new WinningNumber(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumber.getWinningNumbers();
        this.bonusNumber = winningNumber.getBonusNumber();
    }

    public List<Integer> getWinningNumbers(){
        return winningNumbers;
    }
    public int getBonusNumber(){
        return bonusNumber;
    }
}
