package domain;

import java.util.List;

public class LottoCompany {
    private final List<Integer> lottoWinningNumbers;
    private final int lottoWinningBonus;

    public LottoCompany(List<Integer> lottoWinningNumbers, int lottoWinningBonus) {
        this.lottoWinningNumbers = lottoWinningNumbers;
        this.lottoWinningBonus = lottoWinningBonus;
    }

}
