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
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 당첨번호와 중복입니다.");
        }
        if (Lotto.MIN_LOTTO_NUMBER > bonusNumber || bonusNumber > Lotto.MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호의 범위가 1~45를 벗어났습니다.");
        }
    }

    public void checkLottoWinning(Lotto ticket) {
        int matchCount = winningLotto.countMatch(ticket);
        Optional<Rank> matchRanking = Rank.matchRank(matchCount, ticket.containNumber(bonusNumber));
        matchRanking.ifPresent(Rank::plusCount);
    }
}
