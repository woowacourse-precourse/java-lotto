package lotto.domain;

import java.util.Arrays;

public enum LottoRanking {
    FIRST(6, 2000000000),
    SECOND(5,30000000),
    THIRD(5,1500000),
    FOURTH(4,50000),
    FIFTH(3,5000),
    NOTTING(0,0);

    private final int lottoCounts;
    private final int lottoWinningMoney;

    LottoRanking(int counts, int money) {
        lottoCounts=counts;
        lottoWinningMoney=money;
    }
    public static LottoRanking getLottoRanking(int matchLottoCounts, boolean haveBonus){
        if(matchLottoCounts==SECOND.lottoCounts && !haveBonus)
            return THIRD;
        if(matchLottoCounts< FIFTH.lottoCounts)
            return NOTTING;
        return Arrays.stream(LottoRanking.values())
                .filter(lottoRanking -> lottoRanking.isSameCounts(matchLottoCounts))
                .findAny().get();
    }

    public boolean isSameCounts(int lottoCounts){
        return this.lottoCounts==lottoCounts;
    }
}
