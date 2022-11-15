package lotto.constant;

public class ErrorMessage {
    private static final String ERROR_MESSAGE = "[ERROR] ";

    public static final String MONEY_AMOUNT_WRONG_TYPE = ERROR_MESSAGE + "구입금액은 정수로 입력해야 합니다.";
    public static final String MONEY_AMOUNT_CANNOT_BUY_LOTTO = ERROR_MESSAGE + "구입금액이 1000원 이상이여야 로또를 구매할 수 있습니다.";
    public static final String MONEY_AMOUNT_WRONG_VALUE = ERROR_MESSAGE + "구입금액은 1000원 단위여야 합니다.";

    public static final String WRONG_SIZE_MSG = ERROR_MESSAGE + "로또는 6자리 수로 이루어져 있습니다.";
    public static final String WRONG_VALUE_MSG = ERROR_MESSAGE + "로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String DUPLICATE_MSG = ERROR_MESSAGE + "로또 번호는 중복되지 않는 수로 이루어져야 합니다.";

    public static final String WINNING_NUMBER_WRONG_TYPE = ERROR_MESSAGE + "당첨 번호의 입력 서식이 잘못되었습니다.";
    public static final String BONUS_NUMBER_WRONG_RANGE = ERROR_MESSAGE + "보너스 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String BONUS_NUMBER_DUPLICATE = ERROR_MESSAGE + "보너스 번호는 로또 당첨 번호들과 중복되선 안됩니다.";
}
