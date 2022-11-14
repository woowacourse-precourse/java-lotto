package lotto.utils;

import static lotto.utils.Constant.LOTTO_MAXIMUM;
import static lotto.utils.Constant.LOTTO_MINIMUM;
import static lotto.utils.Constant.LOTTO_SIZE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomNumbersGenerator {
    public static List<Integer> randomNumbers() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_MINIMUM, LOTTO_MAXIMUM, LOTTO_SIZE);
    }
}
