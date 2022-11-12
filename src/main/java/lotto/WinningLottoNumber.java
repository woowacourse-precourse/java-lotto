package lotto;

import java.util.List;

public class WinningLottoNumber {

    private List<Integer> winningNumbers;
    private int bonusNumber;

    public WinningLottoNumber(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLottoNumber createWinningLottoNumber(List<Integer> winningNumbers, int bonusNumber) {
        return new WinningLottoNumber(winningNumbers, bonusNumber);
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
