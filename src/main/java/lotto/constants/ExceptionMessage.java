package lotto.constants;

public class ExceptionMessage {
    private ExceptionMessage() {
    }

    public static final String NON_NUMERIC_CHARACTERS = "숫자가 아닌 문자를 입력 하였습니다.";
    public static final String PAYMENT_AMOUNT_ZERO = "지불하실 금액은 0보다 커야 합니다.";
    public static final String THOUSAND_WON_UNIT_EXCEPTION = "금액이 천원 단위가 아니거나 천원 미만을 입력 하였습니다.";
    public static final String NOT_INPUT = "6자리가 입력되지 않았습니다.";
    public static final String DUPLICATION_INPUT = "중복되는 값을 입력하였습니다.";
    public static final String NUMBERS_BETWEEN = "로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String WINNING_DUPLICATION_INPUT = "당첨번호와 중복되는 값을 입력하였습니다.";
    public static final String BONUS_NUMBERS_BETWEEN = "보너스 번호는 1부터 45 사이의 숫자여야 합니다.";

}
