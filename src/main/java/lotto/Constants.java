package lotto;

public class Constants {

    public static final String ASK_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    public static final int MINIMUM_PURCHASE_AMOUNT = 1000;
    public static final String ASK_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    public static final String WINNING_NUMBERS_SEPARATOR = ",";
    public static final int MINIMUM_WINNING_NUMBER = 1;
    public static final int MAXIMUM_WINNING_NUMBER = 45;
    public static final int WINNING_NUMBERS_SIZE = 6;
    public static final String ASK_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    private static final String PREV_ERROR_MESSAGE = "[Error] ";
    public static final String PURCHASE_AMOUNT_IS_NOT_NUMBER_ERROR_MESSAGE = PREV_ERROR_MESSAGE + "숫자가 아닙니다.";
    public static final String PURCHASE_AMOUNT_IS_NOT_IN_RANGE_ERROR_MESSAGE = PREV_ERROR_MESSAGE + "1000원 이상이어야합니다.";
    public static final String PURCHASE_AMOUNT_IS_NOT_DIVIDED_ERROR_MESSAGE =
            PREV_ERROR_MESSAGE + "1000원으로 나누어떨어져야합니다.";
    public static final String WINNING_NUMBERS_IS_NOT_NUMBER_ERROR_MESSAGE = PREV_ERROR_MESSAGE + "숫자가 아닙니다.";
    public static final String WINNING_NUMBERS_IS_NOT_IN_RANGE_ERROR_MESSAGE = PREV_ERROR_MESSAGE + "1~45 수여야 합니다.";
    public static final String WINNING_NUMBERS_SIZE_IS_INVALID_ERROR_MESSAGE = PREV_ERROR_MESSAGE + "당첨번호가 6개여야합니다.";

}
