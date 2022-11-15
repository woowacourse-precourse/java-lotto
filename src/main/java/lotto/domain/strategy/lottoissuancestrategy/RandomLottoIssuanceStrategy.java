package lotto.domain.strategy.lottoissuancestrategy;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.List;

public class RandomLottoIssuanceStrategy implements LottoIssuanceStrategy {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int COUNT_OF_LOTTO_NUMBER = 6;
    
    @Override
    public Lotto issueLotto() {
        return new Lotto(createLottoNumbers());
    }
    
    private List<Integer> createLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, COUNT_OF_LOTTO_NUMBER);
    }
}
