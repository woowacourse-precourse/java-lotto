package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.LottoCondition;

import java.util.ArrayList;
import java.util.List;

public class AutoLottoGenerator {
    private AutoLottoGenerator() {
    }


    public static Lotto objectLotto() {
        return new Lotto(generateLotto());
    }

    private static int getNumberOfLotto(int money) {
        return money / LottoCondition.LOTTO_PRICE.getNum();
    }

    private static List<Integer> generateLotto() {
        return Randoms.pickUniqueNumbersInRange(
                LottoCondition.LOTTO_RANGE_MIN.getNum(), LottoCondition.LOTTO_RANGE_MAX.getNum(), LottoCondition.LOTTO_RANGE_LENGTH.getNum());
    }
}
