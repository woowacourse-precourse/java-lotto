package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;

public class LottoGenerator {
    private final int startNumber;
    private final int endNumber;
    private final int numberCount;

    public LottoGenerator(int startNumber, int endNumber, int numberCount) {
        this.startNumber = startNumber;
        this.endNumber = endNumber;
        this.numberCount = numberCount;
    }

    public List<Integer> createLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(startNumber, endNumber, numberCount);
        return sortLottoNumbers(numbers);
    }

    private List<Integer> sortLottoNumbers(List<Integer> numbers) {
        return numbers.stream().sorted().collect(Collectors.toList());
    }
}