package domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoMaker {

    public Lotto makeLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }

}
