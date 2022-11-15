package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbersGenerator {
    private LottoNumbersGenerator() {
    }

    public static LottoNumbersGenerator getInstance() {
        return new LottoNumbersGenerator();
    }

    public List<Integer> create() {
        List<Integer> numbers = createLottoNumbers();
        return numbers.stream().sorted().collect(Collectors.toUnmodifiableList());
    }

    private List<Integer> createLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
