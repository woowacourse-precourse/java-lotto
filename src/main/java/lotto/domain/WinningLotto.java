package lotto.domain;

import java.util.Collections;

public class WinningLotto {
    private final Lotto winningNumber;
    private final int bonusNumber;

    public WinningLotto(Lotto winningNumber, int bonusNumber){
        Collections.sort(winningNumber.getLotto());
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public Rank match(Lotto lotto) {
        int matchCount = winningNumber.getMatchCount(lotto);
        boolean hasBonusBall = lotto.contains(getBonusNumber());
        return Rank.rankDetermine(matchCount, hasBonusBall);
    }

    public Lotto getWinningNumber() {
        return winningNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
