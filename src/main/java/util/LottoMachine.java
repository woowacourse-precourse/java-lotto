package util;

import camp.nextstep.edu.missionutils.Randoms;
import domain.Lotto;

public class LottoMachine {
    public static Lotto getLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }
}
