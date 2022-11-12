package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoFactory {
    private final int MINIMUM_LOTTO_NUMBER = 1;
    private final int MAXIMUM_LOTTO_NUMBER = 45;
    private final int LOTTO_TOTAL_COUNT = 6;

    public Lotto createLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER, LOTTO_TOTAL_COUNT);
        Lotto lotto = new Lotto(numbers);

        return lotto;
    }
}
