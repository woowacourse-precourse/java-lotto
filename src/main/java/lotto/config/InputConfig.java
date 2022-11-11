package lotto.config;

import lotto.domain.Lotto;

import java.util.Set;

public class InputConfig {
    public static final String ERROR_MESSAGE = "[ERROR]";
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
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    private static void hasCorrectSize(Set<Integer> set) {
        if (set.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    private static void isInRange(int value) {
        if (!(START_INCLUSIVE <= value && value <= END_INCLUSIVE)) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
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
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    private static void isMoreThanZero(long value) {
        if (value < 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    private static void isDividedByPrice(long value) {
        if (value % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

}
