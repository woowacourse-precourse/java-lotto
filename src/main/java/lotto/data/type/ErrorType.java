package lotto.data.type;

public enum ErrorType {

    NUMBER_ERROR("숫자를 입력해야 합니다."),
    LOTTOMONEY_ERROR("%s원 단위로 입력해야 합니다.",
            Integer.toString(LottoNumberType.COST.getValue())),
    LOTTOANSWER_ERROR("쉼표로 구분 된 숫자 %s개를 입력해야 합니다.",
            Integer.toString(LottoNumberType.COUNT.getValue())),
    LOTTORANGE_ERROR("%s ~ %s 사이의 숫자를 입력해야 합니다.",
            Integer.toString(LottoNumberType.MIN.getValue()),
            Integer.toString(LottoNumberType.MAX.getValue()));

    private static final String ERROR_BASE = "[ERROR] ";

    private final Exception exception;

    ErrorType(String message, String... args) {
        this.exception = new IllegalArgumentException(ERROR_BASE + String.format(message, (Object[])args));
    }

    private Exception getException() {
        return this.exception;
    }
}
