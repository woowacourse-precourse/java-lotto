package util;

// 상수를 저장하는 클래스
public class Constant {
    public static final int MINIMUM_NUMBER = 1;
    public static final int MAXIMUM_NUMBER = 45;
    public static final int LOTTO_PRICE = 1000;
    public static final int NUMBER_OF_NUMBERS = 6;

    public static final String NOT_NUMERAL_MONEY_INPUT
            = "[ERROR] 구입 금액에 숫자가 아닌 값이 포함되어 있습니다.";
    public static final String NOT_VALID_MONEY_UNIT
            = "[ERROR] 구입 금액은 1000원 단위로 입력되어야 합니다.";
    public static final String NOT_NUMERAL_NUMBER_INPUT
            = "[ERROR] 숫자가 아닌 값으로 입력되었습니다.";
    public static final String NOT_IN_RANGE_NUMBER_INPUT
            = "[ERROR] 로또 번호는 1~45 범위의 숫자여야 합니다.";
    public static final String NOT_VALID_LENGTH_NUMBERS
            = "[ERROR] 로또 번호는 6개의 숫자로 이루어져야 합니다.";
    public static final String DUPLICATE_NUMBER_ERROR
            = "[ERROR] 로또 번호는 중복되지 않아야 합니다.";
    public static final String DUPLICATE_BONUS_NUMBER_ERROR
            = "[ERROR] 보너스 번호가 로또 번호에 포함됩니다.";
}
