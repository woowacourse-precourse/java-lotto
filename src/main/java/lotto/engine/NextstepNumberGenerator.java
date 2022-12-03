package lotto.engine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;

public class NextstepNumberGenerator implements NumberGenerator {
    public static final int START_RANGE_NUMBER = 1;
    public static final int END_RANGE_NUMBER = 45;
    public static final int COUNT = 6;

    @Override
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(START_RANGE_NUMBER, END_RANGE_NUMBER, COUNT).stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }
}
