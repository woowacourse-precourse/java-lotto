package lotto.model.lottoticket;

import lotto.model.exception.InputException;

import lotto.model.lottostatistics.Ranking;

import lotto.view.ErrorMessages;

public class LottoWinningNumber {

    private final Lotto winningNumbers;
    private final LottoNumber bonusNumber;

    public LottoWinningNumber(Lotto winningNumbers, LottoNumber bonusNumber) {

        validateInput(winningNumbers, bonusNumber);

        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateInput(Lotto winningNumbers, LottoNumber bonusNumber) {
        try {
            validateDuplicatedNumber(winningNumbers, bonusNumber);
        } catch (IllegalArgumentException e) {
            throw new InputException(e.getMessage());
        }
    }

    private void validateDuplicatedNumber(Lotto winningNumbers, LottoNumber bonusNumber) {
        if (winningNumbers.toString().contains(bonusNumber.toString())) {
            throw new IllegalArgumentException(
                    ErrorMessages.DUPLICATED_BONUS_NUMBER.getErrorMessage());
        }
    }

    public Ranking calculateWith(Lotto lotto) {
        int matchCount = lotto.countMatchWith(winningNumbers);
        boolean isBonus = lotto.hasLottoNumber(bonusNumber.getLottoNumber());

        return Ranking.findRanking(matchCount, isBonus);
    }
}
