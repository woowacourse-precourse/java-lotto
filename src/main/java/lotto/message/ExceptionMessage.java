package lotto.message;

public final class ExceptionMessage {

    public static final String PREFIX = "[ERROR] ";

    public static final String AMOUNT_EXCEPTION = "금액은 1,000원 단위로 입력해야 합니다.";
    public static final String TYPE_EXCEPTION = "숫자만 입력이 가능합니다.";
    public static final String PRIZE_EXCEPTION = "숫자와 콤마만 입력이 가능합니다.";
    public static final String SIZE_EXCEPTION = "번호는 반드시 6개여야 합니다.";
    public static final String DUPLICATE_EXCEPTION = "중복된 번호가 존재합니다.";
    public static final String OUT_OF_RANGE_EXCEPTION = "로또 번호의 숫자 범위는 1~45까지이다.";

}
