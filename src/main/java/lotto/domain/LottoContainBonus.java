package lotto.domain;

import java.util.Arrays;

enum LottoContainBonus {
    CONTAIN(true),
    NOT_CONTAIN(false);

    private final boolean contains;

    LottoContainBonus(boolean contains) {
        this.contains = contains;
    }

    public static LottoContainBonus from(boolean contains) {
        return Arrays.stream(LottoContainBonus.values())
                .filter(it -> it.contains == contains)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
