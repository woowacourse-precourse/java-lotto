package lotto.constant;

public final class SystemMessage {
    public static final String ENTER_PURCHASE_COST = "구입금액을 입력해 주세요.";
    public static final String PURCHASE_COUNT_NOTIFICATION = "\n%d개를 구매했습니다.\n";
    public static final String ENTER_WINNING_NUMBERS = "\n당첨 번호를 입력해 주세요.";
    public static final String ENTER_BONUS_NUMBER = "\n보너스 번호를 입력해 주세요.";
    public static final String WINNING_STATISTICS = "\n당첨 통계\n---";
    public static final String EARNINGS_RATE_NOTIFICATION = "총 수익률은 %.1f%%입니다.";

    public static final String ERROR_PREFIX = "[ERROR] ";
    public static final String PURCHASE_COST_TYPE_ERROR = "구매 금액에 문자가 포함될 수 없습니다";
    public static final String PURCHASE_COST_UNIT_ERROR = "구매 금액은 1000원 단위여야 합니다";
    public static final String WINNING_NUMBERS_SIZE_ERROR = "당첨 번호는 6자리여야 합니다";
    public static final String WINNING_NUMBERS_RANGE_ERROR = "당첨 번호는 1부터 45까지의 수로 이루어져야 합니다";
    public static final String WINNING_NUMBERS_FORMAT_ERROR = "당첨 번호는 1,2,3,4,5,6 과 같은 형식이어야 합니다";
    public static final String WINNING_NUMBERS_CONFLICT_ERROR = "당첨 번호에 중복이 포함될 수 없습니다";
    public static final String BONUS_NUMBER_CONFLICT_ERROR = "보너스 번호는 당첨 번호와 중복될 수 없습니다";
}
