package lotto.domain;

import java.util.List;

public class LottoWinningNumber {
    private final Lotto winningNumbers;
    private final int bonusNumber;

    public LottoWinningNumber(Lotto winningNumbers, int bonusNumber) {
        hasBonusNumber(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }

    public List<Integer> getWinningNumbers() {
        return this.winningNumbers.getNumbers();
    }

    private void hasBonusNumber(Lotto winningNumbers, int bonusNumber) {
        if (winningNumbers.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호에 보너스 번호가 있습니다.");
        }
    }
}
