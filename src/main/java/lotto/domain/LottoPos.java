package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;

public class LottoPos {
    private static final int SIZE = 6;
    private static final int RANGE_BEGIN = 1;
    private static final int RANGE_END = 45;

    public Lotto issue() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(RANGE_BEGIN, RANGE_END, SIZE);
        Collections.sort(numbers);
        return new Lotto(numbers);
    }
}
