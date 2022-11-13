package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoBot {

    public Lotto createLotto() {
        return new Lotto(createRandomNumbers());
    }

    private List<Integer> createRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(Lotto.MIN_LOTTO_NUMBER, Lotto.MAX_LOTTO_NUMBER, Lotto.LOTTO_NUMBER_SIZE);
    }
}
