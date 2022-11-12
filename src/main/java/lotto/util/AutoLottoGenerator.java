package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.lottoenum.LottoCondition;

public class AutoLottoGenerator {
    private AutoLottoGenerator() {
    }

    public static Lotto issueAutoLotto() {
        return new Lotto(generateLottoNumbers());
    }

    private static List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(
                LottoCondition.MIN.getValue(), LottoCondition.MAX.getValue(), LottoCondition.LENGTH.getValue());
    }
}
