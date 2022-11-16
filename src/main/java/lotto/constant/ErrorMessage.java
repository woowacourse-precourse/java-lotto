package lotto.constant;

public enum ErrorMessage {
    NOTICE("[ERROR] "),
    UNEXPECTED("예기치 않은 에러가 발생하였습니다."),
    NOT_DIVISIBLE("1개 이상 구매할 수 있어야 하며 잔돈이 남지 않는 금액을 입력해야 합니다."),
    NOT_EQUAL_TO_LOTTO_NUMBER_AMOUNT("로또 숫자 갯수가 맞지 않습니다"),
    INVALID_LOTTO_NUMBER(
            String.format(
                    "로또 숫자는 %d 이상 %d 이하입니다.",
                    LottoRule.MINIMUM_NUMBER.getValue(),
                    LottoRule.MAXIMUM_NUMBER.getValue()
            )
    ),
    DUPLICATE("중복되는 로또 번호가 있습니다."),
    NOT_INTEGER(
            String.format(
                    "%d이상, %d이하의 \"정수\"만 입력하셔야 합니다.",
                    Integer.MIN_VALUE,
                    Integer.MAX_VALUE
            )
    );

    private final String message;
    private final StringBuilder sb = new StringBuilder();

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return sb.append(NOTICE.message).append(this.message).toString();
    }
}
