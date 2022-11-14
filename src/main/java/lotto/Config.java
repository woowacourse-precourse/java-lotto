package lotto;

public class Config {
    public static final int LOTTO_RANGE_START_NUMBER = 1;
    public static final int LOTTO_RANGE_END_NUMBER = 45;
    public static final int LOTTO_LENGTH = 6;
    public static final int BONUS_LOTTO_LENGTH = 1;
    public static final int[] WINNING_RANK_AMOUNT = {2_000_000_000, 30_000_000, 1_500_000, 50_000, 5_000};
    public static final int LOTTO_TICKET_PRICE = 1_000;

    private static final String RANGE_NUMBER_ERROR_MESSAGE = "범위를 표현한 설정값 중에 올바르지 않은 것이 존재합니다.";
    private static final String NATURAL_NUMBER_ERROR_MESSAGE = "자연수 입력이 필요한 설정값 중에 올바르지 않은 것이 존재합니다.";
    private static final String ZERO_OR_NATURAL_NUMBER_ERROR_MESSAGE = "0혹은 자연수 입력이 필요한 설정값 중에 올바르지 않은 것이 존재합니다.";
    private static final String ILLEGAL_LOTTO_ERROR_MESSAGE = "불법 로또 프로그램을 감지했습니다.";

    private Config() {
    }

    public static void validate() {
        checkRangeNumber(LOTTO_RANGE_START_NUMBER, LOTTO_RANGE_END_NUMBER);

        checkNaturalNumber(LOTTO_RANGE_START_NUMBER);
        checkNaturalNumber(LOTTO_RANGE_END_NUMBER);
        checkNaturalNumber(LOTTO_LENGTH);
        checkNaturalNumber(LOTTO_TICKET_PRICE);

        checkZeroOrNaturalNumber(BONUS_LOTTO_LENGTH);

        checkIllegalLotto();
    }

    private static void checkRangeNumber(int start, int end) {
        if (start >= end) {
            throw new IllegalArgumentException(RANGE_NUMBER_ERROR_MESSAGE);
        }
    }

    private static void checkNaturalNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException(NATURAL_NUMBER_ERROR_MESSAGE);
        }
    }

    private static void checkZeroOrNaturalNumber(int number) {
        if (number < 0) {
            throw new IllegalArgumentException(ZERO_OR_NATURAL_NUMBER_ERROR_MESSAGE);
        }
    }

    private static void checkIllegalLotto() {
        if (!(isLongerLottoThanBonus() && isLongerTotalThenNumber() && isRankAmount())) {
            throw new IllegalArgumentException(ILLEGAL_LOTTO_ERROR_MESSAGE);
        }
    }

    private static boolean isLongerLottoThanBonus() {
        return LOTTO_LENGTH >= BONUS_LOTTO_LENGTH;
    }

    private static boolean isLongerTotalThenNumber() {
        return LOTTO_LENGTH + BONUS_LOTTO_LENGTH <= LOTTO_RANGE_END_NUMBER - LOTTO_RANGE_START_NUMBER + 1;
    }

    private static boolean isRankAmount() {
        for (int index = 0; index < WINNING_RANK_AMOUNT.length - 1; index++) {
            if (WINNING_RANK_AMOUNT[index] <= WINNING_RANK_AMOUNT[index + 1]) {
                return false;
            }
        }
        return true;
    }
}
