package lotto.util;

public final class ExceptionMessage {
    private ExceptionMessage() {
    }

    public static final String OUT_OF_RANGE = "[ERROR] 유효한 값 범위를 벗어났습니다.";
    public static final String IS_NOT_NUMERIC = "[ERROR] 입력된 값은 숫자가 아닙니다.";
    public static final String IS_NOT_DIVISIBLE = "[ERROR] " + Constant.MONEY_UNIT +
            "원으로 나누어 떨어지지 않는 값입니다.";
    public static final String IS_NOT_POSITIVE = "[ERROR] 입력된 값은 양수가 아닙니다.";

    public static final String COUNT_NOT_EQUAL = "[ERROR] 입력된 당첨번호는 " +
            Constant.LOTTO_SIZE + "개의 숫자가 아닙니다.";
    public static final String EACH_NOT_NUMERIC = "[ERROR] 입력된 당첨번호는 각각이 숫자여야 합니다.";
    public static final String NUMBER_EACH_OUT_OF_RANGE = "[ERROR] 입력된 당첨번호 각각은 " +
            Constant.START_INCLUSIVE + "부터 " + Constant.END_INCLUSIVE + "까지의 값이어야 합니다";
    public static final String NUMBER_NOT_DISTINCT = "[ERROR] 당첨번호는 중복되서는 안됩니다.";
    public static final String NUMBER_OUT_OF_TYPE_RANGE = "[ERROR] 입력된 당첨번호는 정상적인 범위의 값이 아닙니다.";
}
