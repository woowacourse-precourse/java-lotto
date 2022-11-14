package lotto.domain;

import java.text.DecimalFormat;
import java.util.Arrays;

public enum Rank {
    FIRST_RANK(1, 6, 2000000000),
    SECOND_RANK(2, 7, 30000000),
    THIRD_RANK(3, 5, 1500000),
    FOURTH_RANK(4, 4, 50000),
    FIFTH_RANK(5, 3, 5000),
    NOTHING(6, 0, 0);

    private final int rank;
    private final int match;
    private final int prize;

    Rank(int rank, int match, int prize) {
        this.rank = rank;
        this.match = match;
        this.prize = prize;
    }

    public static Rank findRankByMatch(int matchValue) {
        return Arrays.stream(values())
                .filter(LottoRank -> LottoRank.match == matchValue)
                .findAny()
                .orElse(NOTHING);
    }

    @Override
    public String toString() {
        DecimalFormat priceFormat = new DecimalFormat("###,###");
        if (this == SECOND_RANK) {
            return THIRD_RANK.getMatch() + "개 일치, 보너스 볼 일치 (" + priceFormat.format(this.prize) + "원) - ";
        }
        return this.getMatch() + "개 일치 (" + priceFormat.format(this.prize) + "원) - ";
    }

    public int getRank() {
        return rank;
    }

    public int getMatch() {
        return match;
    }

    public int getPrize() {
        return prize;
    }
}
