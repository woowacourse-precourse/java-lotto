package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Ranking {
    FIRST(6, 2_000_000_000, false, "2,000,000,000"),
    SECOND(5, 30_000_000, true, "30,000,000"),
    THIRD(5, 1_500_000, false, "1,500,000"),
    FOURTH(4, 50_000, false, "50,000"),
    FIFTH(3, 5_000, false, "5,000"),
    NOTHING(0, 0, false, "0");

    private int count;
    private int money;
    private boolean hasBonusNumber;
    private String outputMoney;

    Ranking(int count, int money, boolean hasBonusNumber, String outputMoney) {
        this.count = count;
        this.money = money;
        this.hasBonusNumber = hasBonusNumber;
        this.outputMoney = outputMoney;
    }

    public static Ranking matchRanking(int sameNumberCount, boolean hasBonusNumber) {
        return Arrays.stream(Ranking.values())
                .filter(ranking -> ranking.count == sameNumberCount && ranking.hasBonusNumber == hasBonusNumber)
                .findAny()
                .orElse(NOTHING);
    }

    public static List<Ranking> makeRankingList() {
        List<Ranking> rankings = new ArrayList<>();
        Ranking[] ranking = Ranking.values();

        for (int i = 4; i >= 0; i--) {
            rankings.add(ranking[i]);
        }

        return rankings;
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

    public String getOutputMoney() {
        return outputMoney;
    }
}
