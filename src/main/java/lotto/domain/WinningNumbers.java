package lotto.domain;

import java.util.List;
import java.util.Optional;

public class WinningNumbers {
    private final Lotto winningLotto;
    private final Integer bonusNumber;

    public WinningNumbers(List<Integer> winningLottoNumbers, Integer bonusNumber) {
        this.winningLotto = new Lotto(winningLottoNumbers);
        validateBonusNumber(winningLottoNumbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(List<Integer> winningLottoNumbers, Integer bonusNumber) {
        if (winningLottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(Error.BONUS_NUMBER_IS_DUPLICATE_WITH_WINNING_NUMBERS.getMessage());
        }
        if (bonusNumberIsNotInCorrectRange(bonusNumber)) {
            throw new IllegalArgumentException(Error.LOTTO_NUMBER_IS_NOT_IN_RANGE.getMessage());
        }
    }

    private boolean bonusNumberIsNotInCorrectRange(Integer bonusNumber) {
        return Lotto.MIN_LOTTO_NUMBER > bonusNumber || bonusNumber > Lotto.MAX_LOTTO_NUMBER;
    }

    public void checkLottoWinning(Lotto ticket) {
        int matchCount = winningLotto.countMatch(ticket);
        Optional<Rank> matchRanking = Rank.matchRank(matchCount, ticket.containNumber(bonusNumber));
        matchRanking.ifPresent(Rank::plusCount);
    }
}
