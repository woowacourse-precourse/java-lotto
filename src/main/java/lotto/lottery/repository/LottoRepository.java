package lotto.lottery.repository;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.util.Constant;

public class LottoRepository {
    public static List<Integer> generateLotto() {
        return Randoms.pickUniqueNumbersInRange(Constant.MIN_LOTTO_NUMBER,
                Constant.MAX_LOTTO_NUMBER,
                Constant.LOTTO_NUMBER_SIZE);
    }
}
