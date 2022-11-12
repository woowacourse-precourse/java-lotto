package lotto.domain.winningnumber;

import lotto.domain.lotto.Lotto;
import lotto.domain.rank.Rank;

public class WinningNumber {

    // 당첨번호 (총 6자리)
    private final Lotto winningLotto;

    // 보너스 숫자
    private final int bonusNumber;

    public WinningNumber(Lotto winningLotto, int bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public Rank judge(Lotto lotto) {
        int matchCount = winningLotto.countMatchNumbers(lotto);
        boolean matchBonus = lotto.contains(bonusNumber);

        return Rank.matchRank(matchCount, matchBonus);
    }
}
