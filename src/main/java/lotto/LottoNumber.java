package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class LottoNumber {
    private final static int MIN_LOTTO_NUM = 1;
    private final static int MAX_LOTTO_NUM = 45;
    private final static int COUNT_LOTTO_NUM = 6;

    public List<Integer> create() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUM,
                MAX_LOTTO_NUM, COUNT_LOTTO_NUM);

        Collections.sort(lottoNumbers);

        return lottoNumbers;
    }
}
