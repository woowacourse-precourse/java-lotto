package lotto.constants;

public enum LottoExceptionConstants {
    LOTTO_NUMBER_LENGTH("6개의 숫자가 아닙니다."),
    LOTTO_NUMBER_DUPLICATE("중복된 수가 있습니다."),
    LOTTO_NUMBER_SORT("숫자가 정렬되어 있지 않습니다."),
    LOTTO_NUMBER_RANGE("로또 숫자중 범위 밖의 숫자가 있습니다."),
    INPUT_SPLIT("분할될 수 없는 입력입니다."),
    INPUT_NUMERIC("수가 아닌 입력이 있습니다."),
    INPUT_BLANK("빈 문자열이 입력되었습니다."),
    INPUT_ZERO("0원은 입력받을 수 없습니다."),
    INPUT_REST("입력금액과 로또 금액이 나누어 떨어지지 않습니다."),
    ;


    private final String value;

    LottoExceptionConstants(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
