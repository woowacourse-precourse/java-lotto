package lotto.domain.lotto;

import lotto.dto.LottoCount;

public enum LottoRanking {
    LOSER(-1, false, 0, ""),
    FIFTH(3, false, 5000, "3개 일치 (5,000원) - "),
    FOURTH(4, false, 50000, "4개 일치 (50,000원) - "),
    THIRD(5, false, 1500000, "5개 일치 (1,500,000원) - "),
    SECOND(5, true, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    FIRST(6, false, 2000000000, "6개 일치 (2,000,000,000원) - ");

    private final int lottoCount;
    private final boolean bonus;
    private final int winningAmount;
    private final String message;

    LottoRanking(int lottoCount, boolean bonus, int winningAmount, String message) {
        this.lottoCount = lottoCount;
        this.bonus = bonus;
        this.winningAmount = winningAmount;
        this.message = message;
    }

    public static LottoRanking of(LottoCount lottoCount) {
        for (LottoRanking lottoRanking : LottoRanking.values()) {
            if (lottoRanking.lottoCount == lottoCount.getLottoCount()
                && lottoRanking.bonus == lottoCount.isBonus()) {
                return lottoRanking;
            }
        }
        return LottoRanking.LOSER;
    }

    public int getWinningAmount() {
        return winningAmount;
    }

    public void printMessage(Integer count) {
        if (this == LottoRanking.LOSER) {
            return;
        }
        System.out.println(message + count + "개");
    }
}
