package lotto.vo;

import java.util.List;

public class Winning {
    private final List<Integer> winnings;
    private final Integer bonus;

    public Winning(List<Integer> winnings, Integer bonus) {
        this.winnings = winnings;
        this.bonus = bonus;
    }
}
