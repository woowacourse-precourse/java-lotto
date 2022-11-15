package lotto.model.machine;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.stream.Collectors;

public class RandomNumberGenerator {
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int SIZE_OF_NUMBERS = 6;

    public static Lotto createNumbers() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, SIZE_OF_NUMBERS)
                .stream().sorted().collect(Collectors.toList()));
    }
}
