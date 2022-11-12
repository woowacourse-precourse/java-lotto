package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGenerator {

    static final int LOTTO_MAX_LEN = 6;
    static final int START_RANGE = 1;
    static final int FINAL_RANGE = 45;

    public static List<Integer> createRandomLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START_RANGE, FINAL_RANGE, LOTTO_MAX_LEN);
        numbers = sortByNaturalOrder(numbers);
        return numbers;
    }

    private static List<Integer> sortByNaturalOrder(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

}
