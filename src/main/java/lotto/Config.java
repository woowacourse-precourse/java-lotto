package lotto;

import lotto.utils.Logger;
import lotto.utils.Logger.LogType;

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
    private static final String LONGER_LOTTO_THAN_BONUS = "로또 길이보다 보너스 번호 길이가 클 수 없습니다.";

    private Config() {
    }

    public static void validate() {
    }

    private static void checkRangeNumber(int start, int end) {
        if (start >= end) {
            Logger.log(RANGE_NUMBER_ERROR_MESSAGE, LogType.ERROR);
            throw new IllegalArgumentException();
        }
    }

    private static void checkNaturalNumber(int number) {
        if (number <= 0) {
            Logger.log(NATURAL_NUMBER_ERROR_MESSAGE, LogType.ERROR);
            throw new IllegalArgumentException();
        }
    }

    private static void checkZeroOrNaturalNumber(int number) {
        if (number < 0) {
            Logger.log(ZERO_OR_NATURAL_NUMBER_ERROR_MESSAGE, LogType.ERROR);
            throw new IllegalArgumentException();
        }
    }

    private static void checkIllegalLotto() {
    }

    private static boolean isLongerLottoThanBonus() {
        return LOTTO_LENGTH >= BONUS_LOTTO_LENGTH;
    }

    private static boolean isLongerTotalThenNumber() {
        return LOTTO_LENGTH + BONUS_LOTTO_LENGTH <= LOTTO_RANGE_END_NUMBER - LOTTO_RANGE_START_NUMBER + 1;
    }

    private static boolean isRankAmount() {
        return true;
    }
}
