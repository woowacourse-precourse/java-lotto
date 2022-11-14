package lotto.resource.message;

public enum ErrorMessage {

    NOT_INTEGER_OR_NUMBER_OUT_OF_RANGE_MESSAGE(
            "입력된 값이 숫자가 아니거나 범위를 벗어났습니다."
    ),

    NOT_DIVISIBLE_BY_THOUSANDS_MESSAGE("입력된 값이 1,000원 단위가 아닙니다."),

    NOT_BETWEEN_1_AND_45_MESSAGE("1~45 범위를 벗어났습니다."),
    NUMBER_IS_NOT_POSITIVE_MESSAGE("입력된 값이 양수가 아닙니다."),

    DUPLICATED_NUMBER("로또 넘버에 중복이 있습니다."),
    NOT_SIX_COUNT("로또 넘버가 6개가 아닙니다."),

    DUPLICATE_BONUS_NUMBER_AND_LOTTO_NUMBERS("로또 번호와 중복된 보너스 번호를 입력했습니다.");

    private final String value;

    ErrorMessage(String value) {
        this.value = value;
    }

    public String getValue() {
        return "[ERROR] " + value;
    }
}
