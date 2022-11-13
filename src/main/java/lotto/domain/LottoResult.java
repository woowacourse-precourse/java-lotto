package lotto.domain;

import java.util.Arrays;

public enum LottoResult {
    ZERO_CORRECT(0, 0),
    ONE_CORRECT(1, 0),
    TWO_CORRECT(2, 0),
    THREE_CORRECT(3, 5_000),
    FOUR_CORRECT(4, 50_000),
    FIVE_CORRECT(5, 1_500_000),
    SIX_CORRECT(6, 2_000_000_000),
    FIVE_BONUS_CORRECT(-1, 30_000_000);
    private final int value;
    private final int money;

    LottoResult(int value, int money) {
        this.value = value;
        this.money = money;
    }

    public static LottoResult from(int value) {
        return Arrays.stream(LottoResult.values())
                .filter(it -> it.value == value)
                .filter(it -> it.value >= 0)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public int money() {
        return money;
    }
}
