package lotto.vo;

import java.util.List;

public class Winning {
    private final List<Integer> winnings;
    private final Integer bonus;

    private Winning(List<Integer> winnings, Integer bonus) {
        this.winnings = winnings;
        this.bonus = bonus;
    }

    public static Winning of(List<Integer> winnings, Integer bonus) {
        return new Winning(winnings, bonus);
    }
}
