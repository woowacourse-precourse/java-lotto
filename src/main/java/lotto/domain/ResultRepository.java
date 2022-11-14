package lotto.domain;

import java.util.EnumMap;

public class ResultRepository {

    EnumMap<Rank, Integer> result;
    int totalMoney;

    public ResultRepository() {
        result = new EnumMap<>(Rank.class);
        totalMoney = 0;
        setResult();
    }

    public void setResult() {
        result.put(Rank.FIFTH, 0);
        result.put(Rank.FOURTH, 0);
        result.put(Rank.THIRD, 0);
        result.put(Rank.SECOND, 0);
        result.put(Rank.FIRST, 0);
    }

    public void add(Rank rank) {
        if(rank != Rank.ZERO) {
            result.put(rank, result.getOrDefault(rank, 0) + 1);
            totalMoney += rank.getMoney();
        }
    }

    public int getTotalMoney() {
        return totalMoney;
    }

    public EnumMap<Rank, Integer> getResult() {
        return result;
    }

}
