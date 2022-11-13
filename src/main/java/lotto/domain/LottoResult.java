package lotto.domain;

import java.util.Arrays;

public enum LottoResult {
    ZERO_CORRECT(0),
    ONE_CORRECT(1),
    TWO_CORRECT(2),
    THREE_CORRECT(3),
    FOUR_CORRECT(4),
    FIVE_CORRECT(5),
    SIX_CORRECT(6),
    FIVE_BONUS_CORRECT(-1);
    private final int value;

    LottoResult(int value) {
        this.value = value;
    }

    public static LottoResult from(int value) {
        return Arrays.stream(LottoResult.values())
                .filter(it -> it.value == value)
                .filter(it -> it.value >= 0)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
