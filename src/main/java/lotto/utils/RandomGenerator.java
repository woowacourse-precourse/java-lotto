package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public abstract class RandomGenerator {
    private static final int MIN_NUMBER_BOUND = 1;
    private static final int MAX_NUMBER_BOUND = 45;
    private static final int TOTAL_LOTTO_NUMBER_COUNT = 6;

    public static List<Integer> generateRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER_BOUND, MAX_NUMBER_BOUND, TOTAL_LOTTO_NUMBER_COUNT);
    }
}
