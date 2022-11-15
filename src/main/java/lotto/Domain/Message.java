package lotto.Domain;

public class Message {

    public static final String INPUT_LOTTO_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    public static final String INPUT_LOTTO_WNNING_NUM_MESSAGE = "당첨 번호를 입력해 주세요";
    public static final String INPUT_LOTTO_BONUS_NUMS = "보너스 번호를 입력해 주세요";


    public static final String LOTTO_PURCHASE_NUM_MESSAGE = "%d개를 구매했습니다.";
    public static final String LOTTO_MESSAGE_PREFIX = "[";
    public static final String LOTTO_MESSAGE_SUFFIX = "]";
    public static final String LOTTO_MESSAGE_SEPERATOR = ", ";

    public static final String RANK_MESSAGE = "%d개 일치 (%s원) - %d개";
    public static final String SECOND_RANK_MESSAGE = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
    public static final String EARN_RATIO_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public static final String ERROR_PURCHASE_AMOUNT_IS_NOT_INT = "[ERROR] 구매 금액을 잘못 입력하였습니다.";
    public static final String ERROR_NOT_VALID_WINNING_NUMS_INPUT = "[ERROR] 유효하지 않은 문자가 들어있습니다.";
    public static final String ERROR_DUPLICATE_WINNING_NUMS = "[ERROR] 중복된 당첨 번호입니다.";
    public static final String ERROR_DUPLICATE_BONUS_NUM = "[ERROR] 잘못된 보너스 번호입니다.";
    public static final String ERROR_BONUS_NUM_TYPE = "[ERROR] 당첨 번호는 숫자여야 합니다.";

    public static final String ERROR_LOTTO_NUMS_LENGTH = "[ERROR] 로또 번호의 개수는 6개이어야 합니다. ";
    public static final String ERROR_LOTTO_NUM = "[ERROR] 로또 번호는 %d부터 %d 사이의 숫자여야 합니다.";

}
