package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {

    public static final int START_INCLUSIVE = 1;
    public static final int END_INCLUSIVE = 45;
    public static final int COUNT = 6;

    private LottoGenerator(){}

    private static class LottoHolder{
        private static final LottoGenerator INSTANCE = new LottoGenerator();
    }

    public static LottoGenerator getInstance() {
        return LottoHolder.INSTANCE;
    }

    public List<Integer> makeLotto() {
        List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE, COUNT);
        Collections.sort(lottoNumber);
        return lottoNumber;
    }

}
