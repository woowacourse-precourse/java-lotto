package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    LOSE(0, 0);

    private int matchCount;
    private int price;

    LottoRank(int matchCount, int price) {
        this.matchCount = matchCount;
        this.price = price;
    }

    public boolean isFirst() {
        return FIRST == this;
    }

    public int getTotalWinnerPrize(int count) {
        return this.price * count;
    }

    public static LottoRank getRank(int matchCount, boolean isBonusNumber) {
        LottoRank[] ranks = values();
        for(LottoRank lottoRank : ranks) {
            if(lottoRank.matchCount == matchCount){
                if(matchCount == 5 && isBonusNumber) return SECOND;
                else if (matchCount == 5 && isBonusNumber) return THIRD;
                else return lottoRank;
            }
        }
        return LOSE;
    }

}
