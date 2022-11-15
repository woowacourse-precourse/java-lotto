package lotto;

public class LottoConstant {
    public static final String GAME_START_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String PURCHASE_LOTTO_COUNT_RESULT_MESSAGE = "개를 구매했습니다.";

    public static final String INPUT_IS_NOT_NUMBER_ERROR_MESSAGE = "[ERROR] 입력값이 올바른 숫자가 아닙니다.";
    public static final String INPUT_IS_TOO_LOW_TO_BUY_LOTTO_ERROR_MESSAGE = "[ERROR] 로또를 구매하기에 너무 작은 금액입니다.";
    public static final String INPUT_IS_NOT_FALL_APART_ERROR_MESSAGE = "[ERROR] 입력 금액이 1000으로 나누어 떨어지지 않습니다.";
    public static final String INPUT_IS_NOT_MATCH_REGEX_ERROR_MESSAGE = "[ERROR] 입력 로또 번호가 올바르지 않습니다.";

    private LottoConstant() {
    }
}
