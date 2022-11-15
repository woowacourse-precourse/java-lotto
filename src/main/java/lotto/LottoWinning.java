package lotto;

public class LottoWinning {
    private final int winNumber;

    private final boolean hitBonus;

    public LottoWinning(int winNumber, boolean hitBonus){  // WinningStatistics-compare-001
        this.winNumber = winNumber;
        this.hitBonus = hitBonus;
    }

    @Override
    public boolean equals(Object obj) {
        LottoWinning lottoWinning = (LottoWinning) obj;
        return this.winNumber == lottoWinning.winNumber && this.hitBonus == lottoWinning.hitBonus;
    }
}
