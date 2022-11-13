package lotto.model;

import java.util.List;

public class LottoWinningNumber {
    private static final String BONUS_NUMBER_DUPLICATED_MESSAGE = "당첨 번호와 중복된 보너스 번호를 입력했습니다.";

    List<Integer> lottoWinningNumbers;
    int bonusNumber;

    public LottoWinningNumber(List<Integer> winningNumbers, int bonusNumber) {
        validateLottoNumbersContainBonusNumber(winningNumbers, bonusNumber);
        this.lottoWinningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateLottoNumbersContainBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATED_MESSAGE);
        }
    }

    public List<Integer> getLottoWinningNumbers() {
        return lottoWinningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
