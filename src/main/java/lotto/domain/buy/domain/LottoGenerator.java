package lotto.domain.buy.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.constant.Integer.*;

public class LottoGenerator {
    public List<Integer> numbers = new ArrayList<>();

    public LottoGenerator() {
        List<Integer> tmp = Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX, LOTTO_NUMBER_CNT);
        numbers.addAll(tmp);
        Collections.sort(numbers);

    }
}
