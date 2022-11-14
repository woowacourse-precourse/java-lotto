package domain;

import java.util.List;

public class LottoCompany {

    private final List<Integer> lottoWinningNumbers;
    private final int lottoWinningBonus;
    public LottoCompany(List<Integer> lottoWinningNumbers ,int lottoWinningBonus) {
        this.lottoWinningBonus = lottoWinningBonus;
        validateRange(lottoWinningBonus);
        this.lottoWinningNumbers = lottoWinningNumbers;
    }

    private void validateRange(int lottoWinningBonus) {
        if (lottoWinningBonus < 1 || lottoWinningBonus > 45)
            throw new IllegalArgumentException(ErrorMessage.NOT_RANGE.getErrorMessage());
    }

    public List<Integer> getLottoWinningNumbers() {
        return lottoWinningNumbers;
    }

    public int getLottoWinningBonus() {
        return lottoWinningBonus;
    }
}
