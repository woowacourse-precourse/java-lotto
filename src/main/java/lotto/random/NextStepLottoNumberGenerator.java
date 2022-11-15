package lotto.random;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class NextStepLottoNumberGenerator implements LottoNumberGenerator {
    @Override
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(RANDOM_START_NUMBER, RANDOM_END_NUMBER, LOTTO_NUMBER_COUNT);
    }
}
