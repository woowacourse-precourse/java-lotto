package lotto.domain;

public enum LottoRank {
    BLANK(-1, false, 0, ""),
    FIFTH(3, false, 5_000, "3개 일치 (5,000원) - "),
    FOURTH(4, false, 50_000, "4개 일치 (50,000원) - "),
    THIRD(5, false, 1_500_000, "5개 일치 (1,500,000원) - "),
    SECOND(5, true, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    FIRST(6, false, 2_000_000_000, "6개 일치 (2,000,000,000원) - ");

    private int matchNumber;
    private boolean bonusNumber;
    private int profit;
    private String message;

    LottoRank(int matchNumber, boolean bonusNumber, int profit, String message) {
        this.matchNumber = matchNumber;
        this.bonusNumber = bonusNumber;
        this.profit = profit;
        this.message = message;
    }

    public int getMatchNumber() {
        return this.matchNumber;
    }

    public boolean getBonusNumber() {
        return this.bonusNumber;
    }

    public int getProfit() {
        return this.profit;
    }

    public String getMessage() {
        return this.message;
    }
}
