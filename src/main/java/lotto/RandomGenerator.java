package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Number;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RandomGenerator {
    public List<Number> createRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6)
                .stream()
                .sorted(Comparator.naturalOrder())
                .map(Number::new)
                .collect(Collectors.toList());
    }
}
