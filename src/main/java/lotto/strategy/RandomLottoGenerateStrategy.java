package lotto.strategy;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomLottoGenerateStrategy implements LottoGenerateStrategy {

    private static final int LOTTOSIZE = 6;
    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 45;

    @Override
    public List<Integer> generateLotto() {
        return Randoms.pickUniqueNumbersInRange(MINIMUM_NUMBER, MAXIMUM_NUMBER, LOTTOSIZE);
    }
}
