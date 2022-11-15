package lotto.model;

import java.util.List;

public class WinningLotto {

    private final List<Integer> winningLottoNumbers;
    private final int bonusNumber;

    public WinningLotto(List<Integer> winningLottoNumbers, int bonusNumber) {
        this.winningLottoNumbers = winningLottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinningLottoNumbers() {
        return winningLottoNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
