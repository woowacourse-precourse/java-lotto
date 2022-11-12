package lotto.domain;


import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {
    private final int LOTTO_START_NUMBER = 1;
    private final int LOTTO_END_NUMBER = 45;
    private final int LOTTO_NUMBER_COUNT = 6;

    public List<Integer> issueLotto() {
        List<Integer> lotto = new ArrayList<>(Randoms.pickUniqueNumbersInRange(LOTTO_START_NUMBER,
                LOTTO_END_NUMBER, LOTTO_NUMBER_COUNT));
        Collections.sort(lotto);
        return lotto;
    }
}
