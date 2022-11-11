package util.message;

public class ErrorMessage {
    public static final String PREFIX_ERROR = "[ERROR] ";

    public static final String OVER_THOUSAND_MONEY = "로또 구매금액은 1000원이상이어야합니다.";
    public static final String UNIT_THOUSAND_MONEY = "로또 구입금액은 1000원 단위의 금액만 입력가능합니다.";
    public static final String NOT_STRING_MONEY = "로또 구입금액은 숫자만 가능합니다.(ex - 1000)";

    public static final String HAS_NOT_DUPLICATE_NUM = "로또는 중복된 숫자를 가질 수 없습니다.";
    public static final String IS_NOT_LOTTO_RANGE_NUM = "로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String LOTTO_LENGTH_SIZE_NOT_SIX = "로또 번호길이는 6자리여야합니다.";
}
