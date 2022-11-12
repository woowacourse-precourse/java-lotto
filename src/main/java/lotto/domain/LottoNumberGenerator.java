package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class LottoNumberGenerator {

    public static List<Integer> generate() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(Lotto.MINIMUM_NUMBER, Lotto.MAXIMUM_NUMBER, Lotto.NUMBERS_SIZE);
        Collections.sort(numbers);

        return numbers;
    }
}
