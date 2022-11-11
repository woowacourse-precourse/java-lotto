package lotto.config;

import lotto.domain.Lotto;

import java.util.Set;

public class InputConfig {
    public static final String ERROR_MESSAGE = "[ERROR]";

    private static final String ERROR_INVALID_PRICE= ERROR_MESSAGE+ "%d 단위로 입력해 주세요.";
    private static final String ERROR_NOT_POSITIVE_NUMBER = ERROR_MESSAGE+" 양수인 값만 입력해 주세요.";
    private static final String ERROR_RANGE_OVERFLOW= ERROR_MESSAGE+ "입력 가능한 범위를 초과했습니다. %d~%d 사이의 값을 입력해 주세요.";
    private static final String ERROR_NOT_LOTTO_LENGTH= ERROR_MESSAGE + " %d 개의 숫자를 입력해 주세요.";
    private static final String ERROR_OVERLAPPED_BONUS_NUMBER= ERROR_MESSAGE+ " 당첨 번호와 보너스 번호가 중복됩니다.";

    public static final int START_INCLUSIVE = 1;
    public static final int END_INCLUSIVE = 45;
    public static final int LOTTO_NUMBER_COUNT = 6;
    public static final long LOTTO_PRICE = 1000;


    public static void checkPrizeLottoWithBonus(Lotto lotto, int bonus) {
        isBonusNumberInLotto(lotto.toSet(), bonus);
    }

    public static void checkPrizeLotto(Set<Integer> lotto) {
        hasCorrectSize(lotto);
        for (int i : lotto) {
            isInRange(i);
        }
    }

    public static void isBonusNumberInLotto(Set<Integer> lotto, int bonus) {
        isInRange(bonus);
        if (lotto.contains(bonus)) {
            throw new IllegalArgumentException(ERROR_OVERLAPPED_BONUS_NUMBER);
        }
    }

    private static void hasCorrectSize(Set<Integer> set) {
        if (set.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(String.format(ERROR_NOT_LOTTO_LENGTH, LOTTO_NUMBER_COUNT));
        }
    }

    private static void isInRange(int value) {
        if (!(START_INCLUSIVE <= value && value <= END_INCLUSIVE)) {
            throw new IllegalArgumentException(String.format(ERROR_RANGE_OVERFLOW, START_INCLUSIVE, END_INCLUSIVE));
        }
    }

    // 구입 금액 입력
    public static void checkPurchaseInput(String input) {
        long value = isLongType(input);
        isMoreThanZero(value);
        isDividedByPrice(value);
    }

    private static long isLongType(String input) {
        try {
            return Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NOT_POSITIVE_NUMBER);
        }
    }

    private static void isMoreThanZero(long value) {
        if (value < 0) {
            throw new IllegalArgumentException(ERROR_NOT_POSITIVE_NUMBER);
        }
    }

    private static void isDividedByPrice(long value) {
        if (value % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(String.format(ERROR_INVALID_PRICE, LOTTO_PRICE));
        }
    }

}
