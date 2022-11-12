package lotto.utils;

public class Constants {
    //로또 관련 상수
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    public static final int LOTTO_SIZE = 6;
    public static final int LOTTO_TICKET_PRICE = 1000;

    public static final int WINNING_MIN_COUNT = 3;

    public static final int UNIT_OF_MONEY = 1000;
    //출력 관련 상수
    public static final String LF = "\n";
    public static final String COMMA = ",";
    public static final String COMMA_WITH_BLANK = ", ";
    public static final String OPEN_BRACKET = "[";
    public static final String CLOSED_BRACKET = "]";

    public static final String WINNING_MONEY_FORMAT = "###,###";
    public static final String BONUS_NUMBER_MESSAGE = ", 보너스 볼 일치";
    public static final String COUNT_UNIT_MESSAGE = "개";
    public static final String EQUALS_MESSAGE = " 일치";
    public static final String LEFT_PARENTHESIS = " (";
    public static final String WINNING_MONEY_UNIT_MESSAGE = "원) - ";

    public static final String OUTPUT_MESSAGE_TICKET_QUANTITY = "개를 구매했습니다.";

    public static final String TOTAL_RATE_OF_RETURN = "총 수익률은 ";
    public static final String UNIT_OF_RATE_OF_RETURN = "%입니다.";

    //에러 메시지 상수
    private static final String ERROR_MESSAGE = "[ERROR] ";
    public static final String ERROR_MESSAGE_NOT_DIGIT_PURCHASE_AMOUNT = ERROR_MESSAGE + "구입 금액은 숫자만 입력 가능합니다.";
    public static final String ERROR_MESSAGE_NOT_VALID_UNIT_OF_MONEY = ERROR_MESSAGE + "구입 금액은 1000원 단위만 가능합니다.";

    public static final String ERROR_MESSAGE_NOT_VALID_LOTTO_SIZE = ERROR_MESSAGE + "로또 번호는 단 6개만 입력 가능합니다.";
    public static final String ERROR_MESSAGE_DUPLICATE_NUMBER = ERROR_MESSAGE + "로또 번호는 중복된 숫자를 포함해서는 안됩니다.";
    public static final String ERROR_MESSAGE_NOT_DIGIT_LOTTO_NUMBER = ERROR_MESSAGE + "로또 번호는 숫자만 입력 가능합니다.";
    public static final String ERROR_MESSAGE_NOT_VALID_LOTTO_NUMBER = ERROR_MESSAGE + "로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String ERROR_MESSAGE_DUPLICATE_BONUS_NUMBER = ERROR_MESSAGE + "보너스 숫자는 당첨 번호와 중복되어서는 안됩니다.";
}
