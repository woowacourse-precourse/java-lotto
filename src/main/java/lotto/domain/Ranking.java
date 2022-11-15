package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Ranking {
    FIRST(0, 2000000000, "2,000,000,000", 6, false),
    SECOND(1, 30000000, "30,000,000", 5, true),
    THIRD(2, 1500000, "1,500,000", 5, false),
    FOURTH(3, 50000, "50,000", 4, false),
    FIFTH(4, 5000, "5,000", 3, false),
    LOSING(5, 0, "0", 0, false);

    private final int index;
    private final int money;
    private final String formatedMoney;
    private final int count;
    private final boolean existBonusNumber;

    public static Ranking getRanking(int count, boolean existBonusNumber) {
        return Arrays.stream(Ranking.values())
                .filter(ranking -> ranking.count == count && ranking.existBonusNumber == existBonusNumber)
                .findAny()
                .orElse(LOSING);
    }

    public static List<Ranking> generateRankings() {
        List<Ranking> rankings = new ArrayList<>();
        Ranking[] rankingEnums = Ranking.values();

        for (int i = FIFTH.index; i >= FIRST.index; i--) {
            rankings.add(rankingEnums[i]);
        }

        return rankings;
    }

    public long getMultipleMoneyCount(Integer count) {
        return (long) money * count;
    }

    Ranking(int index, int money, String formatedMoney, int count, boolean existBonusNumber) {
        this.index = index;
        this.money = money;
        this.formatedMoney = formatedMoney;
        this.count = count;
        this.existBonusNumber = existBonusNumber;
    }

    public int getMoney() {
        return money;
    }

    public String getFormatedMoney() {
        return formatedMoney;
    }

    public int getCount() {
        return count;
    }

    public boolean isExistBonusNumber() {
        return existBonusNumber;
    }
}