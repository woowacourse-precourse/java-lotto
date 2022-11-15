package lotto.domain.strategy;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

public class RandomLottoGenerateStrategy implements LottoGenerateStrategy {
    @Override
    public Lotto generate() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_SIZE));
    }
}
