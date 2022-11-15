package lotto;

public class WinnersLotto {
    private Lotto lotto;
    private int bonus;

    private WinnersLotto(Lotto lotto, int bonus) {
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public static WinnersLotto of(Lotto lotto, int bonus) {
        return new WinnersLotto(lotto, bonus);
    }

    public int getBonus() {
        return this.bonus;
    }

    public boolean isContaining(int number) {
        return lotto.isContaining(number);
    }
}
