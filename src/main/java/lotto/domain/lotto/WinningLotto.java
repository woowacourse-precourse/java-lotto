package lotto.domain.lotto;

public class WinningLotto {

    private Lotto lotto;
    private int bonus;

    public WinningLotto(Lotto lotto, int bonus) {
        this.lotto = lotto;
        validate(bonus);
        this.bonus = bonus;
    }

    private void validate(int bonus) {

    }


}
