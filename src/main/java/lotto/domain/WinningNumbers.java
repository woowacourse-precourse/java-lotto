package lotto.domain;

import java.util.List;

public class WinningNumbers {
    private final List<Integer> lotto;
    private final int bonus;

    public WinningNumbers(List<Integer> lotto, int bonus) {
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public List<Integer> getWinNumbers(){
        return this.lotto;
    }

    public int getBonus(){
        return this.bonus;
    }
}
