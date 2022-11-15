package lotto.utils;

public class Constants {
    public static final int LOTTO_TICKET_PRICE = 1000;
    public static final int MAXIMUM_PURCHASE_AMOUNT = 2000000000;


    public static final String INPUT_MESSAGE_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    public static final String INPUT_MESSAGE_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    public static final String INPUT_MESSAGE_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    private static final String ERROR_MESSAGE = "[ERROR] ";
    public static final String ERROR_MESSAGE_NOT_DIGIT_PURCHASE_AMOUNT = ERROR_MESSAGE + "구입 금액은 숫자만 입력 가능합니다.";
    public static final String ERROR_MESSAGE_NOT_VALID_UNIT_OF_MONEY = ERROR_MESSAGE + "구입 금액은 1000원 단위만 가능합니다.";
    public static final String ERROR_MESSAGE_NOT_VALID_RANGE_OF_PURCHASE_AMOUNT = ERROR_MESSAGE + "1회 최소 구입 금액은 1000원 이상, 최대 구입 금액은 20억원 이하입니다.";

}
