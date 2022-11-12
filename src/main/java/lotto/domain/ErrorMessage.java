package lotto.domain;

public class ErrorMessage {
    public static final String PREFIX_ERROR_MESSAGE = "[ERROR]";
    public static final String MONEY_INPUT_ERROR_MESSAGE = PREFIX_ERROR_MESSAGE
            + "구입 금액은 천원 단위의 숫자여야 합니다.";
    public static final String DRAW_NUMBER_INPUT_ERROR_MESSAGE = PREFIX_ERROR_MESSAGE
            + "당첨 번호는 1부터 45사이의 6개로 구성된 숫자여야 합니다.";
}
