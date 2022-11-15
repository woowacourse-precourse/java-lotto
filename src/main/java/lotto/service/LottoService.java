package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static constants.Constants.*;

public class LottoService {

    public Lotto issueLotto() {
        List<Integer> randNums = new ArrayList<>(generatorRandNums());
        Collections.sort(randNums);
        return new Lotto(randNums);
    }

    private List<Integer> generatorRandNums() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_RANGE_START, LOTTO_RANGE_END, LOTTO_NUMS_SIZE);
    }

}
