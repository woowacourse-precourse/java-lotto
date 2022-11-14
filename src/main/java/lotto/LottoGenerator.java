package lotto.user;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedList;
import java.util.List;
import lotto.Lotto;
import lotto.LottoEnums;

public class LottoGenerator {

    public LottoGenerator() {
    }

    private List<Integer> generateNumbers() {
        return Randoms.pickUniqueNumbersInRange(LottoEnums.LOTTO_NUMBER_START.value(),
                                                LottoEnums.LOTTO_NUMBER_END.value(), LottoEnums.LOTTO_SIZE.value());
    }

    public Lotto getLotto() {
        return new Lotto(generateNumbers());
    }
}
