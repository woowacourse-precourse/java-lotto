package domain;

import java.util.List;

import static controller.Util.*;

public class LottoCompany {

    private final List<Integer> winningNumbers;
    private final int winningBonus;

    public LottoCompany(List<Integer> winningNumbers, int winningBonus) {
        this.winningBonus = winningBonus;
        validateRange(winningBonus);
        validateSize(winningNumbers);
        validateDuplicate(winningNumbers);
        validateNumbersRange(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getWinningBonus() {
        return winningBonus;
    }

}
