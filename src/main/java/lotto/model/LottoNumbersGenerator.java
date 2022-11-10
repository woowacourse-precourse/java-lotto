package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class LottoNumbersGenerator {
    public List<Integer> create() {
        List<Integer> numbers = createLottoNumbers();
        return numbers;
    }

    private List<Integer> createLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
