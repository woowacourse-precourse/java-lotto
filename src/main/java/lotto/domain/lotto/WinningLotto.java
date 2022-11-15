package lotto.domain.lotto;

public class WinningLotto {
    private Lotto lotto;
    private Bonus bonus;

    public WinningLotto(Lotto lotto, Bonus bonus) {
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public Lotto getLotto() {
        return lotto;
    }

    public Bonus getBonus() {
        return bonus;
    }
}
