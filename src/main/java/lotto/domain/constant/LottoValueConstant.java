package lotto.domain.constant;

public enum LottoValueConstant {
    LOTTO_MINIMUM_NUMBER(1),
    LOTTO_MAXIMUM_NUMBER(45),
    LOTTO_NUMBER_OF_DIGITS(6),
    SECOND_PLACE(7),
    BONUS_NUMBER_IDX(0),
    ZERO(0);

    final int value;

    LottoValueConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
