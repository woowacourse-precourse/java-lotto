package lotto.model;

import java.util.List;

public class LottoWinningNumber {
    List<Integer> lottoWinningNumbers;
    int bonusNumber;

    public LottoWinningNumber(List<Integer> winningNumbers, int bonusNumber) {
        validateWinningNumbersContainBonusNumber(winningNumbers, bonusNumber);
        this.lottoWinningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateWinningNumbersContainBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("당첨 번호와 중복된 보너스 번호를 입력했습니다.");
        }
    }

    public List<Integer> getLottoWinningNumbers() {
        return lottoWinningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
