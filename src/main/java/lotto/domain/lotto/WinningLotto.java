package lotto.domain.lotto;

public class WinningLotto {

    private Lotto lotto;
    private int bonus;

    public WinningLotto(Lotto lotto, int bonus) {
        this.lotto = lotto;
        this.bonus = bonus;
    }
}
