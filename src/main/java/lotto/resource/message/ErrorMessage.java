package lotto.resource.message;

public enum ErrorMessage {

    PAYOUT_IS_NOT_INTEGER_OR_NUMBER_OUT_OF_RANGE_MESSAGE("입력된 값이 숫자가 아니거나 범위를 벗어났습니다."),
    PAYOUT_IS_NOT_DIVISIBLE_BY_THOUSANDS_MESSAGE("입력된 값이 1,000원 단위가 아닙니다."),

    NUMBER_IS_NOT_BETWEEN_1_AND_45_MESSAGE("입력된 값이 1,000원 단위가 아닙니다."),
    NUMBER_IS_NOT_POSITIVE_MESSAGE("입력된 값이 양수가 아닙니다."),

    LOTTO_NUMBER_DUPLICATE("로또 넘버에 중복이 있습니다."),
    LOTTO_NUMBER_COUNT_IS_NOT_SIX("로또 넘버가 6개가 아닙니다.");

    private final String value;

    ErrorMessage(String value) {
        this.value = value;
    }

    public String getValue() {
        return "[ERROR] " + value;
    }
}
