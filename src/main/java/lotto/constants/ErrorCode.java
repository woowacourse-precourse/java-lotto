package lotto.constants;

public class ErrorCode {
    private static final String ERROR_MESSAGE = "[ERROR]";

    public static final String NOT_NUMBER = ERROR_MESSAGE +
            " 구입 금액으로 숫자를 입력해야 합니다.";
    public static final String UNSUITABLE_UNIT = ERROR_MESSAGE +
            " 로또 금액은 1000원 단위이어야 합니다.";
    public static final String INVALID_NUMBER_OF_DIGITS = ERROR_MESSAGE +
            " 번호는 총 6개로 구성되어야 합니다.";
    public static final String INVALID_NUMERIC_CONFIGURATION = ERROR_MESSAGE +
            " 번호는 중복되지 않는 숫자로 구성되어야 합니다.";

    public static final String INVALID_NUMBER_RANGE = ERROR_MESSAGE +
            " 번호는 1부터 45사이의 숫자여야 합니다.";

}
