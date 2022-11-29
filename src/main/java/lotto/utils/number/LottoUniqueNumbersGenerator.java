package lotto.utils.number;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;

public class LottoUniqueNumbersGenerator implements LottoNumbersGenerator {

    private final int min;
    private final int max;

    public LottoUniqueNumbersGenerator(int min, int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public List<Integer> generate(int size) {
        return Collections.unmodifiableList(Randoms.pickUniqueNumbersInRange(min, max, size));
    }
}
