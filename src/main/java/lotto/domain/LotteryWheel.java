package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Comparator;
import java.util.List;

public class LotteryWheel {
    private final static int MIN_LOTTO_NUMBER = 1;
    private final static int MAX_LOTTO_NUMBER = 45;
    private final static int NUMBERS_COUNT = 6;

    public List<Integer> generateLotteryNumbers() {
        List<Integer> lotteryNumbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, NUMBERS_COUNT);
        lotteryNumbers.sort(Comparator.naturalOrder());

        return lotteryNumbers;
    }
}
