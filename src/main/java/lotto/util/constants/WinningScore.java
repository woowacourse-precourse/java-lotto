package lotto.util.constants;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum WinningScore {
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    BONUS(1, 30_000_000) {
        @Override
        public String printWinningScore() {
            return String.format("%d개 일치, 보너스 볼 일치 (%,d원)", FIVE.score, money);
        }
    },
    SIX(6, 200_000_0000);

    private static final Map<Integer, WinningScore> BY_COUNT =
            Stream.of(values()).collect(Collectors.toMap(WinningScore::getScore, e -> e));

    public final int score;
    public final int money;

    WinningScore(int score, int money) {
        this.score = score;
        this.money = money;
    }

    public int getScore() {
        return score;
    }

    public int getMoney() {
        return money;
    }

    public static WinningScore getScore(int count) {
        return BY_COUNT.get(count);
    }

    public String printWinningScore() {
        return String.format("%d개 일치 (%,d원)", score, money);
    }
}
