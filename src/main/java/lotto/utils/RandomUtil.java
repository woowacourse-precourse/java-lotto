package lotto.utils;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.utils.ConstantUtil.LOTTO_NUMBER_SIZE;
import static lotto.utils.ConstantUtil.MAX_LOTTO_NUMBER;
import static lotto.utils.ConstantUtil.MIN_LOTTO_NUMBER;

import java.util.List;

public final class RandomUtil {
    public static List<Integer> createRandomNumbers() {
        return pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_NUMBER_SIZE);
    }

    private RandomUtil() {
    }
}
