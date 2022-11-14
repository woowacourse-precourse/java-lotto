package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoIssuer {
    public Lotto issueLotto() {
        return new Lotto(randomNumberGenerator());
    }

    private List<Integer> randomNumberGenerator() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
