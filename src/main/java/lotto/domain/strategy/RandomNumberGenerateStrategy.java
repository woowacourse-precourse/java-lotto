package lotto.domain.strategy;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;
import lotto.domain.NumberGenerateStrategy;

public class RandomNumberGenerateStrategy implements NumberGenerateStrategy {
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;
    private static final int LOTTO_SIZE = 6;

    @Override
    public List<Integer> generateNumbers() {
        return Collections
                .unmodifiableList(Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX, LOTTO_SIZE));
    }
}
