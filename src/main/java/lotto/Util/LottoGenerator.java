package lotto.Util;

import static lotto.Constant.LottoValue.MAX_RANGE;
import static lotto.Constant.LottoValue.MIN_RANGE;
import static lotto.Constant.LottoValue.NUMBER_EA;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.Lotto;



public class LottoGenerator {
    public static Lotto generate() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_RANGE, MAX_RANGE, NUMBER_EA);
        final Lotto lotto = new Lotto(numbers);

        return lotto;
    }
}
