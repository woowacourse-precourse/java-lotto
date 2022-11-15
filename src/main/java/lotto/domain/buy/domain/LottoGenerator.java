package lotto.domain.buy.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    static final int LOTTO_NUMBER_START = 1;
    static final int LOTTO_NUMBER_END = 45;
    static final int LOTTO_NUMBER_CNT = 6;
    public List<Integer> numbers = new ArrayList<>();

    public LottoGenerator() {
        List<Integer> tmp = Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_START, LOTTO_NUMBER_END, LOTTO_NUMBER_CNT);
        numbers.addAll(tmp);
        Collections.sort(numbers);

    }

}
