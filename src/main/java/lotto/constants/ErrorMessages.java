package lotto.constants;

public final class ErrorMessages {

    private static final String PREFIX = "[ERROR] ";
    public static final String MONEY_SIGN = PREFIX + "구입 금액은 0보다 작을 수 없습니다.";
    public static final String MONEY_UNIT = PREFIX + "구입 금액은 1,000원 단위여야 합니다.";
    public static final String NUMBER_SIZE = PREFIX + "6개의 숫자를 입력해야 합니다.";
    public static final String NUMBER_DUPLICATE = PREFIX + "중복된 숫자는 입력할 수 없습니다.";
    public static final String NUMBER_RANGE = PREFIX + "1 ~ 45 사이의 숫자만 입력할 수 있습니다.";
    public static final String BONUS_DUPLICATE = PREFIX + "보너스 숫자는 당첨 숫자와 중복될 수 없습니다.";
    public static final String INPUT = PREFIX + "숫자만 입력할 수 있습니다.";

    private ErrorMessages() {
    }
}
