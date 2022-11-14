package lotto.generator;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.global.LottoConstants.*;

public class RandomLottoGenerator {

    public static Lotto makeLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER,
                                                                 MAX_LOTTO_NUMBER_COUNT)
                                       .stream()
                                       .sorted()
                                       .collect(Collectors.toList());

        return new Lotto(numbers);
    }
}
