package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomLotto {
    public Lotto getRandomLotto() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(LottoNumber.getMinNumber(),
                LottoNumber.getMaxNumber(),
                Lotto.getLottoSize()
        );
        return new Lotto(randomNumbers);
    }
}
