package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.common.Constant;

import java.util.List;

public class LottoGenerator {

    public static List<Integer> createRandomLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(Constant.MIN_LOTTO_RANGE, Constant.MAX_LOTTO_RANGE, Constant.LOTTO_SIZE);
    }
}
