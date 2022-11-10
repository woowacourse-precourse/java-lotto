package lotto;

import java.util.List;
import java.util.Set;

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
}
