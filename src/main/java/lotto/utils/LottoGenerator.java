package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {

    public static final int START_INCLUSIVE = 1;
    public static final int END_INCLUSIVE = 45;
    public static final int COUNT = 6;

    private LottoGenerator(){}

    public static List<Integer> makeLotto() {
        List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE, COUNT);

        return lottoNumber;
    }

}
