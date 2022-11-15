package lotto.constant;

public class ErrorMessage {
    private static final String ERROR_MESSAGE = "[ERROR] ";

    public static final String MONEY_AMOUNT_WRONG_TYPE = ERROR_MESSAGE + "구입금액은 정수로 입력해야 합니다.";
    public static final String MONEY_AMOUNT_CANNOT_BUY_LOTTO = ERROR_MESSAGE + "구입금액이 1000원 이상이여야 로또를 구매할 수 있습니다.";
    public static final String MONEY_AMOUNT_WRONG_VALUE = ERROR_MESSAGE + "구입금액은 1000원 단위여야 합니다.";
}
