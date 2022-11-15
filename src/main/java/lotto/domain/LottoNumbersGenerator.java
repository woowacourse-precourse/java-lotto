package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class LottoNumbersGenerator {
    public List<Integer> getLottoNumbers() {
        List<Integer> numbers = generateLottoNumbers();
        return numbers;
    }

    private List<Integer> generateLottoNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }
}
