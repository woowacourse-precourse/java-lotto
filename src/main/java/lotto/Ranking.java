package lotto;

import java.util.Arrays;
import java.util.List;

public enum Ranking {
    FIRST(6,2_000_000_000),
    SECOND(7,30_000_000),
    THIRD(5,1_500_000),
    FOURTH(4,50_000),
    FIFTH(3,5_000),
    NONE(0,0);

    private final int match;
    private final int money;

    Ranking(int match, int money) {
        this.match = match;
        this.money = money;
    }

    public Integer getMoney()
    {
        return this.money;
    }

    public static Ranking getRank(int numberOfMatch, boolean isContainBounus){
        if (numberOfMatch == 5)
            if (isContainBounus)
                return SECOND;

        return Arrays.stream(values())
                .filter(ranking -> ranking.match == numberOfMatch)
                .findFirst()
                .orElse(NONE);
    }
}
