package lotto.generator;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.List;

import static lotto.global.LottoConstants.*;

public class RandomLottoGenerator {

    public static Lotto makeLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER,
                                                                 MAX_LOTTO_NUMBER_COUNT);

        return new Lotto(numbers);
    }
}
