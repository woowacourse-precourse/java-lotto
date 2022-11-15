package lotto.domain;

public enum Rank {
    BLANK(-1, false, 0, ""),
    FIFTH(3, false, 5_000, "3개 일치 (5,000원) - "),
    FOURTH(4, false, 50_000, "4개 일치 (50,000원) - "),
    THIRD(5, false, 1_500_000, "5개 일치 (1,500,000원) - "),
    SECOND(5, true, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    FIRST(6, false, 2_000_000_000, "6개 일치 (2,000,000,000원) - ");

    private final int RANK_NUMBER;
    private final boolean BONUS_NUMBER;
    private final int PROFIT;

    private final String MESSAGE;

    Rank(int rankNumber, boolean bonusNumber, int profit, String message) {
        this.RANK_NUMBER = rankNumber;
        this.BONUS_NUMBER = bonusNumber;
        this.PROFIT = profit;
        this.MESSAGE = message;

    }

    public int getRANK_NUMBER() {
        return RANK_NUMBER;
    }

    public boolean getBONUS_NUMBER() {
        return BONUS_NUMBER;
    }

    public int getPROFIT() {
        return PROFIT;
    }

    public String getMESSAGE() {
        return MESSAGE;
    }
}
