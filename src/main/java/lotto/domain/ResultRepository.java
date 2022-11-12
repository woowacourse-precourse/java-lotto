package lotto.domain;

import java.util.EnumMap;

public class ResultRepository {

    EnumMap<Rank, Integer> result;
    int totalMoney;

    public ResultRepository() {
        result = new EnumMap<>(Rank.class);
        totalMoney = 0;
    }

    public void add(Rank rank) {
        result.put(rank, result.getOrDefault(rank, 0) + 1);
        totalMoney += rank.getMoney(rank);
    }

    public Integer getResultAboutRank(Rank rank) {
        return result.get(rank);
    }

    public int getTotalMoney() {
        return totalMoney;
    }

}
