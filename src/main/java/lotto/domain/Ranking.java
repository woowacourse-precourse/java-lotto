package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Ranking {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    NOTHING(0, 0, false);

    private int count;
    private int money;
    private boolean hasBonusNumber;

    Ranking(int count, int money, boolean hasBonusNumber) {
        this.count = count;
        this.money = money;
        this.hasBonusNumber = hasBonusNumber;
    }

    public static Ranking matchRanking(int sameNumberCount, boolean hasBonusNumber) {
        return Arrays.stream(Ranking.values())
                .filter(ranking -> ranking.count == sameNumberCount && ranking.hasBonusNumber == hasBonusNumber)
                .findAny()
                .orElse(NOTHING);
    }

    public static List<Ranking> makeRankingList() {
        List<Ranking> rankingList = new ArrayList<>();
        Ranking[] rankingArr = Ranking.values();

        for (int i = 4; i >= 0; i--) {
            rankingList.add(rankingArr[i]);
        }

        return rankingList;
    }

    public int getMoney() {
        return money;
    }

    public int getCount() {
        return count;
    }

    public boolean isHasBonusNumber() {
        return hasBonusNumber;
    }
}
