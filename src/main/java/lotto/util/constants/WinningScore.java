package lotto.util.constants;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum WinningScore {
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    BONUS(1, 30_000_000),
    SIX(6, 200_000_0000);

    private static final Map<Integer, WinningScore> BY_COUNT =
            Stream.of(values()).collect(Collectors.toMap(WinningScore::getCount, e -> e));

    public final int count;
    public final int money;

    WinningScore(int score, int money) {
        this.count = score;
        this.money = money;
    }

    public int getCount() {
        return count;
    }

    public int getMoney() {
        return money;
    }

    public static WinningScore getScore(int count) {
        return BY_COUNT.get(count);
    }
}
