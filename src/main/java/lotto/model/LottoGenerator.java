package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.constant.Constant;

public class LottoGenerator {

    private static List<Integer> generateNumbers() {
        return Randoms.pickUniqueNumbersInRange(Constant.LOTTO_START_NUMBER, Constant.LOTTO_END_NUMBER,
                Constant.LOTTO_SIZE);
    }

}
