package lotto.domain;

import java.util.Arrays;
import java.util.List;

public enum Ranking {
    FIRST(2000000000, 6, 0),
    SECOND(30000000, 5, 1),
    THIRD(1500000, 5, 0),
    FOURTH(50000, 4, 0),
    FIFTH(5000, 3, 0),
    DEFAULT(0, 0, 0);

    final int prize;
    final int lottoCount;
    final int bonusCount;
    Ranking(int prize, int lottoCount, int bonusCount) {
        this.prize = prize;
        this.lottoCount = lottoCount;
        this.bonusCount = bonusCount;
    }



/*
    public static Ranking findRanking(int cnt, int bonus) {
        return Arrays.stream(Ranking.values())
                .filter(ranking -> ranking.lottoCount == cnt && ranking.bonusCount == bonus)
                .findAny()
                .orElse(DEFAULT);
    }

    public long multiple(Integer count) {
        return (long) prize * count;
    }

    public int getCount() {
        return lottoCount;
    }

    public int getPrize() {
        return prize;
    }

    public int getHasBonusCount() {
        return bonusCount;
    }
*/
}
