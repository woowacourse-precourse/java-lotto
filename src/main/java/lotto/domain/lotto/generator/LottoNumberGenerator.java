package lotto.domain.lotto.generator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoNumberGenerator {
    private final static int MIN_NUMBER = 1;
    private final static int MAX_NUMBER = 45;
    private final static int LOTTO_NUMBER_COUNT = 6;

    public static List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER,MAX_NUMBER,LOTTO_NUMBER_COUNT);
    }
}
