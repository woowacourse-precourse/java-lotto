package lotto.utils;

public class Constants {

    public static final int LOTTO_NUMBER_COUNT = 6;

    public static final int LOTTO_MIN_NUMBER = 1;

    public static final int LOTTO_MAX_NUMBER = 45;

    public static final int LOTTO_PRICE = 1_000;

    public static final int FIRST_PRIZE_MONEY = 2_000_000_000;

    public static final int SECOND_PRIZE_MONEY = 30_000_000;

    public static final int THIRD_PRIZE_MONEY = 1_500_000;

    public static final int FOURTH_PRIZE_MONEY = 50_000;

    public static final int FIFTH_PRIZE_MONEY = 5_000;

    public static final String FIRST_PRIZE_MESSAGE = "6개 일치 (2,000,000,000원) - ";

    public static final String SECOND_PRIZE_MESSAGE = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";

    public static final String THIRD_PRIZE_MESSAGE = "5개 일치 (1,500,000원) - ";

    public static final String FOURTH_PRIZE_MESSAGE = "4개 일치 (50,000원) - ";

    public static final String FIFTH_PRIZE_MESSAGE = "3개 일치 (5,000원) - ";

    public static final String NUMBER_REGEX = "^[0-9]+$";

    public static final String PURCHASE_MESSAGE = "구입금액을 입력해 주세요.";

    public static final String INVALID_PURCHASE_INPUT_MESSAGE = "[ERROR] 올바른 숫자를 입력해주세요.";

    public static final String NOT_PRICE_UNIT_PURCHASE_INPUT_MESSAGE = "[ERROR] 1,000 단위로 입력해주세요.";

    public static final String INCORRECT_LOTTO_NUMBER_LENGTH_MESSAGE = "[ERROR] 6개의 숫자를 입력해주세요.";

    public static final String DUPLICATED_LOTTO_NUMBER_MESSAGE = "[ERROR] 중복 숫자를 입력하였습니다.";

    public static final String RANGE_OVER_LOTTO_NUMBER_MESSAGE = "[ERROR] 1~45 사이의 숫자를 입력하세요.";

    public static final String PURCHASE_LOTTO_COUNT_MESSAGE = "개를 구매했습니다.";

    public static final String LOTTO_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";

    public static final String LOTTO_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
}
