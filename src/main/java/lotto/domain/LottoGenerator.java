package lotto.domain;

import static lotto.domain.Lotto.LOTTO_NUMBERS_SIZE;
import static lotto.domain.Lotto.LOWER_BOUND_NUMBER;
import static lotto.domain.Lotto.UPPER_BOUND_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoGenerator {
    public static Lotto generate() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LOWER_BOUND_NUMBER, UPPER_BOUND_NUMBER,
                LOTTO_NUMBERS_SIZE);
        return new Lotto(numbers);
    }
}
