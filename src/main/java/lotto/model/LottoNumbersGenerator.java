package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class LottoNumbersGenerator {
    private LottoNumbersGenerator() {
    }

    public static LottoNumbersGenerator getInstance() {
        return new LottoNumbersGenerator();
    }

    public List<Integer> create() {
        List<Integer> numbers = createLottoNumbers();
        Collections.sort(numbers);
        return numbers;
    }

    private List<Integer> createLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
