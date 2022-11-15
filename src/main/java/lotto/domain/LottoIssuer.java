package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoIssuer {

    public Lotto issueLotto(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    public Lotto issueLotto() {
        return new Lotto(randomNumberGenerator());
    }

    public List<Integer> randomNumberGenerator() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
