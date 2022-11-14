package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.Collections;
import java.util.List;

import static constants.Constants.*;

public class LottoService {

    public Lotto issueLotto() {
        List<Integer> randNums = Randoms.pickUniqueNumbersInRange(LOTTO_RANGE_START, LOTTO_RANGE_END, LOTTO_NUMS_SIZE);
        Collections.sort(randNums);
        return new Lotto(randNums);
    }
}
