package lotto.utils;

public class Constants {
    //로또 관련 상수
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    public static final int LOTTO_SIZE = 6;
    public static final int LOTTO_TICKET_PRICE = 1000;
    public static final int WINNING_MIN_COUNT = 3;
    public static final int UNIT_OF_MONEY = 1000;

    //입력 관련 상수
    public static final String INPUT_MESSAGE_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    public static final String INPUT_MESSAGE_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    public static final String INPUT_MESSAGE_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    //출력 관련 상수
    public static final String LF = "\n";
    public static final String COMMA = ",";
    public static final String COMMA_WITH_BLANK = ", ";
    public static final String OPEN_BRACKET = "[";
    public static final String CLOSED_BRACKET = "]";

    public static final String WINNING_MONEY_FORMAT = "###,###";

    public static final String OUTPUT_MESSAGE_WINNING_RESULT = "%s개 일치%s (%s원) - ";
    public static final String OUTPUT_MESSAGE_BONUS_BALL = ", 보너스 볼 일치";
    public static final String OUTPUT_MESSAGE_NUMBER_OF_WINNING_LOTTO = "%s개";
    public static final String OUTPUT_MESSAGE_TICKET_QUANTITY = "%s개를 구매했습니다.\n";
    public static final String OUTPUT_MESSAGE_RATE_OF_RETURN = "\n총 수익률은 %.1f%%입니다.\n";

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
