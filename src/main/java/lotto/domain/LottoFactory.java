package lotto.domain;

import lotto.Randoms;

import java.util.List;

import static lotto.domain.Lotto.*;

public class LottoFactory {

    public Lotto createRandomLotto() {
        List<Integer> randomNumbers = Randoms.createUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, NUMBER_COUNT);
        return new Lotto(randomNumbers);
    }
}
