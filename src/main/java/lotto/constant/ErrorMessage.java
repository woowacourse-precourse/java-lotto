package lotto.constant;

public class ErrorMessage {
    public static final String PURCHASE_AMOUNT_TYPE_ERROR = "[ERROR] 구입 금액은 숫자만 입력 가능합니다.";
    public static final String PURCHASE_AMOUNT_RANGE_ERROR = "[ERROR] 구입 금액은 1000원 이상입니다.";
    public static final String PURCHASE_AMOUNT_UNIT_ERROR = "[ERROR] 구입 금액은 1000원 단위입니다.";
    public static final String LOTTO_ELEMENTS_DUPLICATE_ERROR = "[ERROR] 로또 번호는 중복되지 않는 6개의 수로 구성되어야 합니다.";
    public static final String LOTTO_ELEMENTS_RANGE_ERROR = "[ERROR] 로또 번호는 1 ~ 45 사이의 양수입니다.";
    public static final String LOTTO_ELEMENTS_SIZE_ERROR = "[ERROR] 로또 번호는 총 6개로 구성되어야 합니다.";
    public static final String WINNING_NUMBER_TYPE_ERROR = "[ERROR] 당첨 번호는 숫자와 콤마(,)로 이루어져야 합니다.";
    public static final String WINNING_NUMBER_RANGE_ERROR = "[ERROR] 당첨 번호는 1 ~ 45 사이의 양수입니다.";
    public static final String WINNING_NUMBER_SIZE_ERROR = "[ERROR] 당첨 번호는 6개를 입력해야 합니다.";
}
