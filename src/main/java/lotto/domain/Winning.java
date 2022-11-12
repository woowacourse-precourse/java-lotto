package lotto.domain;

public class Winning {
    Lotto lotto;
    WinningLotto wLotto;
    WinningTable winningTable;

    public Winning(Lotto lotto, WinningLotto wLotto) {
        this.lotto = lotto;
        this.wLotto = wLotto;
    }

    public void calMyScore() {
       int correctedCount = wLotto.compareNumbers(lotto.getNumbers());
       boolean containsBonus = wLotto.containsBonus(lotto.getNumbers());

       WinningCondition w = WinningCondition.getRank(correctedCount, containsBonus);

    }
}
