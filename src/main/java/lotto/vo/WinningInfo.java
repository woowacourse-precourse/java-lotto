package lotto.vo;

import java.util.List;

public class WinningInfo {
    private final List<Integer> winningNumbers;
    private final Integer bonus;

    public WinningInfo(List<Integer> winningNumbers, Integer bonus) {
        this.winningNumbers = winningNumbers;
        this.bonus = bonus;
    }

    public Integer getBonus() {
        return bonus;
    }

    public boolean isWinningNumbersContaining(Integer target) {
        return winningNumbers.contains(target);
    }
}
