package lotto.util.constants;

public final class GameConstants {
    public static final String INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    public static final String INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    public static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static final String OUTPUT_PURCHASE_COUNT = "개를 구매했습니다.";
    public static final String OUTPUT_WINNING_STATS = "당첨 통계\n---";

    public static final String ERROR_IS_NOT_NUMBER = "[ERROR] 구입 금액은 숫자여야 합니다.";
    public static final String ERROR_IS_NOT_POSITIVE_NUMBER = "[ERROR] 구입 금액은 양수여야 합니다.";
    public static final String ERROR_IS_NOT_DIVISIBLE_BY_1000 = "[ERROR] 구입 금액은 1000원으로 나누어 떨어져야 합니다.";

    public static final int LOTTO_AMOUNT_UNIT = 1000;

    private GameConstants() {

    }
}
