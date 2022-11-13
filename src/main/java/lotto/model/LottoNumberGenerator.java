package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoNumberGenerator {

    private final List<Integer> numbers;

    public LottoNumberGenerator() {
        this.numbers = generateNumbers();
    }

    private List<Integer> generateNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public List<Integer> getNumber() {
        return numbers;
    }

}
