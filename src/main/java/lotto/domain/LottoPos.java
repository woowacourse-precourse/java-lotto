package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;

public class LottoPos {
    private static final int SIZE = 6;
    private static final int RANGE_BEGIN = 1;
    private static final int RANGE_END = 45;

    public Lotto issue() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(RANGE_BEGIN, RANGE_END, SIZE);
        return new Lotto(numbers.stream()
                .sorted()
                .map(LottoNumber::new)
                .collect(Collectors.toList())
        );
    }
}
