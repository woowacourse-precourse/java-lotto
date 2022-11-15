package lotto.domain;

import lotto.validation.LottoValidation;

import java.util.List;

public class WinningLotto {
    private final Lotto winningLotto;
    private final int bonusNumber;
    private final List<Integer> winningNumbers;

    public WinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        LottoValidation.isContainBonusNumber(winningNumbers,bonusNumber);
        this.winningLotto = new Lotto(winningNumbers);
        this.bonusNumber = bonusNumber;
        this.winningNumbers = winningNumbers;
    }
    public Rank getRankOf(Lotto userLotto) {
        int matchCount = userLotto.calculateMatchCount(winningNumbers);
        boolean isBonusNumber = userLotto.checkBonusNumber(bonusNumber);
        return Rank.lottoMatchRank(matchCount, isBonusNumber);
    }
}
