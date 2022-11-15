package domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class NumberGenerator {

    public static Lotto createLottoNumber() {
        List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(lottoNumber);
    }
}
