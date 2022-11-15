package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class RandomNumbersGenerationStrategy implements NumbersGenerationStrategy {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int NUMBERS_COUNT = 6;

    @Override
    public List<Integer> numbers() {
        return pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, NUMBERS_COUNT)
                .stream().sorted()
                .collect(Collectors.toList());
    }
}
