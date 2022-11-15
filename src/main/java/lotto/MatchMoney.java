package lotto;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum MatchMoney {
    FIVE(3, 5000),
    FOUR(4, 50000),
    THREE(5, 1500000),
    TWO(5, 30000000),
    ONE(6, 2000000000);


    private final int matchCount;
    private final int money;


    MatchMoney(int matchCount, int money) {
        this.matchCount = matchCount;
        this.money = money;
    }

    public static lotto.MatchMoney Matching(int count) {
        return Arrays.stream((values()))
                .filter(MatchMoney -> MatchMoney.getMatchCount() == count)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException());
    }
}