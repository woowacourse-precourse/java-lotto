package lotto.domain.buy.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    public List<Integer> numbers = new ArrayList<>();

    public LottoGenerator() {
        List<Integer> tmp = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        numbers.addAll(tmp);
        Collections.sort(numbers);

    }

}
