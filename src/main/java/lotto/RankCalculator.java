package lotto;

public class RankCalculator {

    private final WinningLotto winningLotto;
    private final BonusNumber bonusNumber;

    public RankCalculator(WinningLotto winningLotto, BonusNumber bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public Rank calculate(Lotto lotto) {
        int matchCount = winningLotto.countSameNumber(lotto);
        if (matchCount == Rank.SECOND.getMatchCount()) {
            return Rank.getRank(matchCount, checkBonusNumber(lotto));
        }
        return Rank.getRank(matchCount, false);
    }

    private boolean checkBonusNumber(Lotto lotto) {
        return bonusNumber.existIn(lotto);
    }
}
