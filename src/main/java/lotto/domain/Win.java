package lotto.domain;

import java.util.Arrays;

public enum Win {
    NON(0), ONE(0), TWO(0),
    THREE(5_000),
    FOUR(50_000),
    FIVE(1_500_000),
    SIX(2_000_000_000),
    FIVE_BONUS(30_000_000);

    private final Integer PRIZE;

    Win(Integer PRIZE) {
        this.PRIZE = PRIZE;
    }

    public static Integer getPRIZE(int matchCount, boolean bonus) {
        return Arrays.stream(Win.values())
                .filter(win -> !(matchCount == 5 && bonus) && win.ordinal() == matchCount)
                .map(win->win.PRIZE)
                .findAny()
                .orElse(FIVE_BONUS.PRIZE);
    }
}
