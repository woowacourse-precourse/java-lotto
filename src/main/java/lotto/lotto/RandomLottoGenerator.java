package lotto.lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomLottoGenerator implements LottoGenerator {
    @Override
    public Lotto generate() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

        return new Lotto(randomNumbers);
    }
}
