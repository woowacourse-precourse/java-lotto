package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LottoNumberGenerator {

    public LottoNumberGenerator() {
    }

    public List<Integer> generate() {
        List<Integer> numbers = new ArrayList<>(
                Randoms.pickUniqueNumbersInRange(Lotto.NUMBER_RANGE_START, Lotto.NUMBER_RANGE_END, Lotto.NUMBER_COUNT));
        numbers.sort(Comparator.naturalOrder());
        return Collections.unmodifiableList(numbers);
    }
}
