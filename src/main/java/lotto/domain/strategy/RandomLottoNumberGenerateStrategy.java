package lotto.domain.strategy;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.domain.LottoNumberGenerateStrategy;

public class RandomLottoNumberGenerateStrategy implements LottoNumberGenerateStrategy {
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;
    private static final int LOTTO_SIZE = 6;

    @Override
    public List<Integer> generateNumbers() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX, LOTTO_SIZE);
    }
}
