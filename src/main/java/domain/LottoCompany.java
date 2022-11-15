package domain;

import view.ErrorMessage;

import java.util.List;

public class LottoCompany {

    private final List<Integer> winningNumbers;
    private final int winningBonus;

    public LottoCompany(List<Integer> winningNumbers, int winningBonus) {
        this.winningBonus = winningBonus;
        validateRange(winningBonus);
        this.winningNumbers = winningNumbers;
    }

    private void validateRange(int lottoWinningBonus) {
        if (lottoWinningBonus < 1 || lottoWinningBonus > 45)
            throw new IllegalArgumentException(ErrorMessage.NOT_RANGE.getErrorMessage());
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getWinningBonus() {
        return winningBonus;
    }
}
