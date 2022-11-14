package lotto.domain.lotto;

import lotto.dto.LottoCount;

public enum LottoRanking {
    FIRST(6), SECOND(5), THIRD(5), FOURTH(4), FIFTH(3), LOSER(2);

    private final int lottoCount;

    LottoRanking(int lottoCount) {
        this.lottoCount = lottoCount;
    }

    public static LottoRanking of(LottoCount lottoCount) {
        if (lottoCount.getLottoCount() == 5 && lottoCount.isBonus()) {
            return LottoRanking.SECOND;
        }
        if (lottoCount.getLottoCount() == 5 && !lottoCount.isBonus()) {
            return LottoRanking.THIRD;
        }

        for (LottoRanking lottoRanking : LottoRanking.values()) {
            if (lottoRanking.lottoCount == lottoCount.getLottoCount()) {
                return lottoRanking;
            }
        }
        return LottoRanking.LOSER;
    }
}
