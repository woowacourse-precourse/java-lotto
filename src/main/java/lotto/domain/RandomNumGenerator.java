package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.system.Constant;

import java.util.List;

public final class RandomNumGenerator {
    private RandomNumGenerator() {}

    public static List<Integer> makeUniqueRandomList() {
        return Randoms.pickUniqueNumbersInRange(
                Constant.START_INCLUSIVE,
                Constant.END_INCLUSIVE,
                Constant.LOTTO_SIZE
        );
    }
}
