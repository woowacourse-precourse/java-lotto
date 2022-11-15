package lotto.lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomLottoGenerator implements LottoGenerator {
    @Override
    public Lotto generate() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(Lotto.LOTTO_NUMBER_LOWER_BOUND,
                Lotto.LOTTO_NUMBER_UPPER_BOUND, Lotto.LOTTO_MAX_SIZE);

        return new Lotto(randomNumbers);
    }
}
