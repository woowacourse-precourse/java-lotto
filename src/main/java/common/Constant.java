package common;

public final class Constant {

    public static final int LOTTO_START_NUMBER = 1;
    public static final int LOTTO_END_NUMBER = 45;
    public static final int LOTTO_PRICE = 1000;

    public static final String NOT_VALID_RANGE_EXCEPTION = "[ERROR] 로또 번호는 "+ LOTTO_START_NUMBER + "부터" + LOTTO_END_NUMBER + " 사이의 숫자여야 합니다.";
    public static final String NOT_VALID_PRICE_EXCEPTION = "[ERROR] 로또 구입 금액은 1000원으로 나누어 떨어져야 합니다.";

    public static final String EXIST_DUPLICATE_NUMBER_EXCEPTION = "[ERROR] 로또 번호는 중복이 되어서는 안됩니다.";
    public static final String NOT_MATCH_PICK_NUMBER_EXCEPTION = "[ERROR] 당첨번호는 6개여야 합니다.";
    public static final String NOT_NUMBER_EXCEPTION = "[ERROR] 입력값이 올바르지 않습니다.";


    public static final String PURCHASE_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String PURCHASE_COUNT_MESSAGE = "개를 구매했습니다.";
    public static final String WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해주세요.";
    public static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해주세요.";
    public static final String WINNING_STATISTICS_MESSAGE = "당첨 통계";
    public static final String UNDER_SCORE_MESSAGE = "----";



}
