package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.view.OutputView;

public class NumberGenerator {
    private static final Integer MIN_RANGE = 1;
    private static final Integer MAX_RANGE = 45;
    private static final Integer COUNT = 6;

    private final List<Integer> numbers = new ArrayList<>();

    public NumberGenerator() {
        List<Integer> generatedNumbers = Randoms.pickUniqueNumbersInRange(MIN_RANGE, MAX_RANGE, COUNT);
        OutputView.printCreatedNumbers(generatedNumbers);
        for (Integer number : generatedNumbers) {
            numbers.add(number);
        }
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

}
