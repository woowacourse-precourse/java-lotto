package lotto.domain;

import java.text.DecimalFormat;
import java.util.Arrays;

public enum Ranking {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private static final DecimalFormat formatter = new DecimalFormat("###,###");
    private static final String BONUS_FORMAT = "%d개 일치, 보너스 볼 일치 (%s원)";
    private static final String NORMAL_FORMAT = "%d개 일치 (%s원)";

    private final int matchCount;
    private final int money;

    Ranking(int matchCount, int money) {
        this.matchCount = matchCount;
        this.money = money;
    }

    public static Ranking from(int matchCount, boolean bonus) {
        if (matchCount == 5 && bonus) {
            return SECOND;
        }
        return Arrays.stream(Ranking.values())
                .filter(ranking -> ranking.match(matchCount))
                .findAny()
                .orElse(MISS);
    }

    public long reward(int count) {
        return money * (long) count;
    }

    private boolean match(int matchCount) {
        if (this == SECOND) {
            return false;
        }
        return this.matchCount == matchCount;
    }

    @Override
    public String toString() {
        if (this == SECOND) {
            return String.format(BONUS_FORMAT, matchCount, formatter.format(money));
        }
        return String.format(NORMAL_FORMAT, matchCount, formatter.format(money));
    }
}
