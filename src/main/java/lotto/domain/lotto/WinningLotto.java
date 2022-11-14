package lotto.domain.lotto;

public class WinningLotto {

    private final Lotto lotto;
    private final BonusBall bonusBall;

    public WinningLotto(Lotto lotto, BonusBall bonusBall) {
        this.lotto = lotto;
        this.bonusBall = bonusBall;
    }

    public static WinningLotto create(Lotto lotto, BonusBall bonusBall) {
        return new WinningLotto(lotto, bonusBall);
    }

    public Lotto getLotto() {
        return lotto;
    }

    public BonusBall getBonusBall() {
        return bonusBall;
    }
}
