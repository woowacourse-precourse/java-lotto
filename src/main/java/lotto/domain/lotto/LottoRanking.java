package lotto.domain.lotto;

import lotto.dto.LottoCount;

public enum LottoRanking {
    FIRST(6, false,2000000000), SECOND(5, true, 30000000), THIRD(5, false, 1500000), FOURTH(4,
        false, 50000), FIFTH(3, false,5000), LOSER(-1, false, 0),;

    private final int lottoCount;
    private final boolean bonus;
    private final int winningAmount;

    LottoRanking(int lottoCount, boolean bonus, int winningAmount) {
        this.lottoCount = lottoCount;
        this.bonus = bonus;
        this.winningAmount = winningAmount;
    }

    public static LottoRanking of(LottoCount lottoCount) {
        for (LottoRanking lottoRanking : LottoRanking.values()) {
            if (lottoRanking.lottoCount == lottoCount.getLottoCount() && lottoRanking.bonus == lottoCount.isBonus()) {
                return lottoRanking;
            }
        }
        return LottoRanking.LOSER;
    }

    public int getWinningAmount() {
        return winningAmount;
    }
}
