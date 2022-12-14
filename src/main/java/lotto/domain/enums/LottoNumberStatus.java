package lotto.domain.enums;

import lotto.message.ErrorMessage;

public enum LottoNumberStatus {
    MIN(1),
    MAX(45);

    private final int value;

    LottoNumberStatus(final int value) {
        this.value = value;
    }

    public static void validateLottoNumber(final int number) {
        if (MIN.value > number || MAX.value < number) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_BOUNDS_LOTTO_NUMBER_ERROR);
        }
    }
}
