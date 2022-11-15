package lotto.domain.lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.common.Constant;

import java.util.List;

public final class LottoGenerator {
    private LottoGenerator() {}

    public static List<Integer> createRandomLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(Constant.MIN_LOTTO_RANGE, Constant.MAX_LOTTO_RANGE, Constant.LOTTO_SIZE);
    }
}
