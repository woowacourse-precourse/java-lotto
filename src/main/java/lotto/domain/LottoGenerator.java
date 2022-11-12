package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    public List<Integer> createLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }

    public List<Integer> sortLotto(List<Integer> numbers) {
        Collections.sort(numbers);
        return numbers;
    }
}
