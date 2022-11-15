package lotto.Enum;

import java.util.ArrayList;
import java.util.List;

public enum Rank {
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000),
    FIRST(6, 2000000000),
    DEFAULT(0, 0),
    ;
    private final int hitNumberCount;
    private final int prizeMoney;

    Rank(int hitNumberCount, int prizeMoney) {
        this.hitNumberCount = hitNumberCount;
        this.prizeMoney = prizeMoney;
    }

    public List<Integer> getRank() {
        List<Integer> rank = new ArrayList<>();
        rank.add(this.hitNumberCount);
        rank.add(this.prizeMoney);
        return rank;
    }
}
