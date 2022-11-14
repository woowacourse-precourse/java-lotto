package lotto.domain;

import java.util.Arrays;

enum LottoSameCount {
    ZERO_SAME(0),
    ONE_SAME(1),
    TWO_SAME(2),
    THREE_SAME(3),
    FOUR_SAME(4),
    FIVE_SAME(5),
    SIX_SAME(6);

    private final int count;

    LottoSameCount(int count) {
        this.count = count;
    }

    public static LottoSameCount from(int count) {
        return Arrays.stream(LottoSameCount.values())
                .filter(it -> it.count == count)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
