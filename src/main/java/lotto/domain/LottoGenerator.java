package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    private static final int LOTTO_SIZE = 6;
    private static final int LOTTO_START = 1;
    private static final int LOTTO_END = 45;

    private final List<Integer> numbers = new ArrayList<>();

    public LottoGenerator() {
        List<Integer> generatedNumbers = Randoms.pickUniqueNumbersInRange(LOTTO_START, LOTTO_END, LOTTO_SIZE);
        OutputView.printGeneratedLottoNumbers(generatedNumbers);
        for (int number : generatedNumbers) {
            numbers.add(number);
        }
    }

    public List<Integer> getLotto() {
        return this.numbers;
    }
}
