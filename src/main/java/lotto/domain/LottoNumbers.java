package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;

public class LottoNumbers {

    public LottoNumbers() {
    }
    private static final int CNT_LOTTO_NUMBER = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    public List<Integer> setRandomNumbers(){
        List<Integer> LottoNumberList = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER,MAX_LOTTO_NUMBER,CNT_LOTTO_NUMBER);
        Collections.sort(LottoNumberList);
        return LottoNumberList;
    }

}
