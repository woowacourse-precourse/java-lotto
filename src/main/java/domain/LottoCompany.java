package domain;

import java.util.List;

public class LottoCompany {
    private int lottoWinningBonus;
    private List<Integer> lottoWinningNumbers;

    public List<Integer> getLottoWinningNumbers() {
        return lottoWinningNumbers;
    }

    public int getLottoWinningBonus() {
        return lottoWinningBonus;
    }

    public void setLottoWinningNumbers(List<Integer> lottoWinningNumbers) {
        this.lottoWinningNumbers = lottoWinningNumbers;
    }

    public void setLottoWinningBonus(int lottoWinningBonus) {
        this.lottoWinningBonus = lottoWinningBonus;
    }
}
