package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class LottoNumber {
    private final static int MIN_LOTTO_NUM = 1;
    private final static int MAX_LOTTO_NUM = 45;
    public final static int LOTTO_SIZE = 6;

    public List<Integer> create() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUM,
                MAX_LOTTO_NUM, LOTTO_SIZE);

        Collections.sort(lottoNumbers);

        return lottoNumbers;
    }
}
