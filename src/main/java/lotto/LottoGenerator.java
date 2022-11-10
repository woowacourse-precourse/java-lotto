package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    private final int startNumber;
    private final int endNumber;
    private final int numberCount;

    public LottoGenerator(int startNumber, int endNumber, int numberCount) {
        this.startNumber = startNumber;
        this.endNumber = endNumber;
        this.numberCount = numberCount;
    }

    private List<Integer> createLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(startNumber, endNumber, numberCount);
    }

    private void sortLottoNumbers(List<Integer> lottoNumbers) {
        Collections.sort(lottoNumbers);
    }

    public List<Integer> getLottoNumbers() {
        List<Integer> numbers = createLottoNumbers();
        sortLottoNumbers(numbers);

        return numbers;
    }
}