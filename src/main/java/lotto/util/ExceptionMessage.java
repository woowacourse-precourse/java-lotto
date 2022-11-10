package lotto.util;

public final class ExceptionMessage {
    private ExceptionMessage() {
    }

    public static final String OUT_OF_RANGE = "[ERROR] 유효한 값 범위를 벗어났습니다.";
    public static final String IS_NOT_NUMERIC = "[ERROR] 입력된 값은 숫자가 아닙니다.";
    public static final String IS_NOT_DIVISIBLE = "[ERROR] " + Constant.MONEY_UNIT +
            "원으로 나누어 떨어지지 않는 값입니다.";
}
