package util;

public class ExceptionMessage {

    private ExceptionMessage() {}

    private static final String PREFIX = "[ERROR] ";
    public static final String OUT_OF_SIZE = PREFIX + "6자리가 아닙니다.";
    public static final String DUPLICATE_NUMBER = PREFIX + "중복된 숫자가 있습니다.";
    public static final String OUT_OF_RANGE = PREFIX + "범위를 벗어난 숫자가 있습니다.";
    public static final String REST_EXISTS = PREFIX + "구매 단위로 나누어 떨어지지 않습니다.";
    public static final String NOT_MONEY_FORMAT = PREFIX + "돈 형식을 입력해야 합니다.";
    public static final String NOT_NUMBER_FORMAT = PREFIX + "숫자 형식을 입력해야 합니다.";

}
