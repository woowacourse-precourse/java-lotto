package lotto.constants;

public enum LottoExceptionConstants {
    LOTTO_NUMBER_LENGTH("6개의 숫자가 아닙니다."),
    LOTTO_NUMBER_DUPLICATE("중복된 수가 있습니다."),
    LOTTO_NUMBER_SORT("숫자가 정렬되어 있지 않습니다."),
    LOTTO_NUMBER_RANGE("로또 숫자중 범위 밖의 숫자가 있습니다.");


    private final String value;

    LottoExceptionConstants(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
