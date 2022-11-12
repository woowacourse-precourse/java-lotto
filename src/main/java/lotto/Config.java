package lotto;

public class Config {
    public static final int LOTTO_RANGE_START_NUMBER = 1;
    public static final int LOTTO_RANGE_END_NUMBER = 45;
    public static final int LOTTO_LENGTH = 6;
    public static final int BONUS_LOTTO_LENGTH = 1;
    public static final int[] WINNING_RANK_AMOUNT = {2_000_000_000, 30_000_000, 1_500_000, 50_000, 5_000};
    public static final int LOTTO_TICKET_PRICE = 1_000;

    private Config() {
    }

    public static void validate() {
    }

    private static void checkRangeNumber(int start, int end) {
    }

    private static void checkNaturalNumber(int number) {
    }

    private static void checkZeroAndNaturalNumber(int number) {
    }

    private static void checkIllegalLotto() {
    }

    private static void checkLongerLottoThanBonus() {
    }

    private static void checkLongerTotalThenNumber() {
    }

    private static void checkRankAmount() {
    }
}
