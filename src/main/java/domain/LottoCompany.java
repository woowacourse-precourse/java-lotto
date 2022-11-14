package domain;

import java.util.List;

public class LottoCompany {

    private final List<Integer> lottoWinningNumbers;
    private final int lottoWinningBonus;
    public LottoCompany(List<Integer> lottoWinningNumbers ,int lottoWinningBonus) {
        validateRange(lottoWinningBonus);
        this.lottoWinningBonus = lottoWinningBonus;
        this.lottoWinningNumbers = lottoWinningNumbers;
    }

    public List<Integer> getLottoWinningNumbers() {
        return lottoWinningNumbers;
    }

    public int getLottoWinningBonus() {
        return lottoWinningBonus;
    }

    private void validateComma(String lottoWinningNumbers) {
        if (!lottoWinningNumbers.contains(","))
            throw new IllegalArgumentException(ErrorMessage.NOT_COMMA.getErrorMessage());
    }

    private void validateRange(int lottoWinningBonus) {
        if (lottoWinningBonus < 1 || lottoWinningBonus > 45)
            throw new IllegalArgumentException(ErrorMessage.NOT_RANGE.getErrorMessage());
    }
}
