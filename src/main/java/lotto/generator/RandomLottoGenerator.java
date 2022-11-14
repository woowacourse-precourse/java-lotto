package lotto.generator;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.global.LottoConstants.MAX_LOTTO_NUMBER;
import static lotto.global.LottoConstants.MAX_LOTTO_NUMBER_COUNT;
import static lotto.global.LottoConstants.MIN_LOTTO_NUMBER;

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
