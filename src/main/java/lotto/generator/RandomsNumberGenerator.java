package lotto.generator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RandomsNumberGenerator implements NumberGenerator {

    @Override
    public List<Integer> generate(int min, int max, int size) {
        if (size != 0 && size > max - min + 1) {
            throw new IllegalArgumentException("[Error] ~~~~");
        }
        return Randoms.pickUniqueNumbersInRange(min, max, size)
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
