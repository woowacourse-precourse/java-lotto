package lotto.exception;

public class ExceptionName {

    public static final int NUMBER_OF_WINNING_NUMBERS = 6;
    public static final String MONEY_UNIT_EXCEPTION = "[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.";
    public static final String MONEY_NOT_INTEGER_EXCEPTION = "[ERROR] 구입 금액은 정수형태여야 합니다.";
    public static final String LOTTO_NUMBERS_EXCEPTION = "[ERROR] 로또 번호의 개수는 6개 입니다.";
    public static final String LOTTO_RANGE_EXCEPTION = "[ERROR] 로또 번호는 1이상 45이하 범위의 숫자여야 합니다.";
    public static final String LOTTO_DUPLICATE_EXCEPTION = "[ERROR] 중복된 숫자가 존재합니다.";
    public static final String WINNING_NUMBERS_NOT_INTEGER_EXCEPTION = "[ERROR] 당첨 번호는 정수 형태여야 합니다.";
    public static final String WINNING_NUMBERS_NUMBERS_EXCEPTION =
            "[ERROR] 당첨 번호의 개수는 " + NUMBER_OF_WINNING_NUMBERS + "개입니다.";
    public static final String WINNING_NUMBERS_RANGE_EXCEPTION = "[ERROR] 당첨 번호는 1이상 45이하 범위의 숫자여야 합니다.";
    public static final String WINNING_NUMBERS_DUPLICATE_EXCEPTION = "[ERROR] 중복된 숫자가 존재합니다.";
    public static final String BONUS_NUMBER_NOT_INTEGER_EXCEPTION = "[ERROR] 보너스 번호는 하나의 정수 형태여야 합니다.";
    public static final String BONUS_NUMBER_RANGE_EXCEPTION = "[ERROR] 보너스 번호는 1이상 45이하 범위의 숫자이어야 합니다.";
    public static final String BONUS_NUMBER_DUPLICATE_EXCEPTION = "[ERROR] 중복되는 숫자가 존재합니다.";
}
