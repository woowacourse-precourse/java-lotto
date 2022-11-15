package domain;

import view.ErrorMessage;

import java.util.HashSet;
import java.util.List;

import static controller.Util.validateDuplicate;
import static controller.Util.validateSize;

public class LottoCompany {

    private final List<Integer> winningNumbers;
    private final int winningBonus;

    public LottoCompany(List<Integer> winningNumbers, int winningBonus) {
        this.winningBonus = winningBonus;
        validateRange(winningBonus);
        validateSize(winningNumbers);
        validateDuplicate(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getWinningBonus() {
        return winningBonus;
    }


    private void validateRange(int lottoWinningBonus) {
        if (lottoWinningBonus < 1 || lottoWinningBonus > 45)
            throw new IllegalArgumentException(ErrorMessage.NOT_RANGE.getErrorMessage());
    }
}
