package lotto.domain;

public class WinningNumbers {
    private final Lotto lotto;
    private final int bonus;

    private WinningNumbers(Lotto lotto, int bonus) {
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public Lotto getWinNumbers(){
        return this.lotto;
    }

    public int getBonus(){
        return this.bonus;
    }
}
