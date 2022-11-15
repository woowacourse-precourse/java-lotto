package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;

public class LottoGenerator {
    private LottoGenerator() {}

    public static List<Integer> generate() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                Validator.START_NUMBER,
                Validator.END_NUMBER,
                Validator.LOTTO_SIZE
        );
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
