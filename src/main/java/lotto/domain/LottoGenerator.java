package lotto.domain;

import static lotto.domain.LottoValidator.validateLottoNumbers;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGenerator {

    private final static int START = 1;
    private final static int END = 45;
    private final static int DIGIT = 6;

    public List<Integer> generateNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START, END, DIGIT)
                .stream()
                .sorted()
                .collect(Collectors.toList());
        validateLottoNumbers(numbers);
        return numbers;
    }
}
