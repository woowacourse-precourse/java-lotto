package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

import static lotto.LottoConstant.*;

public class LottoMachine {

    public List<Integer> createNumbers() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUM,
                MAX_LOTTO_NUM, LOTTO_SIZE);

        Collections.sort(lottoNumbers);

        return lottoNumbers;
    }
}
