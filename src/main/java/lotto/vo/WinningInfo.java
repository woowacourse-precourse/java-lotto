package lotto.vo;

import java.util.List;

public class WinningInfo {
    private final List<Integer> winnings;
    private final Integer bonus;

    public WinningInfo(List<Integer> winnings, Integer bonus) {
        this.winnings = winnings;
        this.bonus = bonus;
    }

    public Integer getBonus() {
        return bonus;
    }

    public boolean contains(Integer target) {
        return winnings.contains(target);
    }
}
