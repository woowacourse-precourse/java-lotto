package lotto;

import java.util.List;
import java.util.stream.Collectors;
import lotto.utils.LottoNumbersValidator;

public class Lotto {

    public static final int LOTTO_NUMBERS_SIZE = 6;
    public static final int LOWER_BOUND_NUMBER = 1;
    public static final int UPPER_BOUND_NUMBER = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LottoNumbersValidator.validate(numbers);
        this.numbers = numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
