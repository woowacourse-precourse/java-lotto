package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class LottoNumbersGenerator {
    public List<Integer> getLottoNumbers() {
        List<Integer> numbers = generateLottoNumbers();
        sortLottoNumbers(numbers);
        return numbers;
    }

    private List<Integer> generateLottoNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return null;
    }

    private List<Integer> sortLottoNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
        return numbers;
    }
}
