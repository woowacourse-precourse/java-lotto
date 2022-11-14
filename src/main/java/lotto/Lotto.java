package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    public static final int LOTTO_NUMBERS_SIZE = 6;
    public static final int LOWER_BOUND_NUMBER = 1;
    public static final int UPPER_BOUND_NUMBER = 45;
    public static final int LOTTO_UNIT = 1000;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public static Lotto create() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LOWER_BOUND_NUMBER, UPPER_BOUND_NUMBER,
                LOTTO_NUMBERS_SIZE);
        return new Lotto(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
