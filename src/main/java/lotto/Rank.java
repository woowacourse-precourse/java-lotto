package lotto;

import java.util.ArrayList;
import java.util.List;

public enum Rank {

    FIRST(6, "2,000,000,000원", 0),
    SECOND(5, "30,000,000원", 1),
    THIRD(5, "1,500,000원", 0),
    FOURTH(4, "50,000원", 0),
    FIFTH(3, "5,000원", 0);
    private final int count;
    private final String money;
    private final int bonus;

    Rank(int count, String money, int bonus) {
        this.count = count;
        this.money = money;
        this.bonus = bonus;
    }

    public static List<Rank> getResult(List<Integer>[] resultList) {
        List<Rank> rankList = new ArrayList<Rank>();
        for (List<Integer> result : resultList) {
            Rank rank = findRank(result);
            rankList.add(rank);
        }
        return rankList;
    }

    public static Rank findRank(List<Integer> result) {
        int count = result.get(0);
        int bonus = result.get(1);

        if (count == 5) {
            if (bonus == 1) {
                return SECOND;
            }
            return THIRD;
        }

        for (Rank value : values()) {
            if (value.count == count) {
                return value;
            }
        }
        return null;
    }

}
