package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import lotto.utils.Validator;

public class Lotto {

    public static final int LOTTO_NUMBERS_SIZE = 6;
    public static final int LOWER_BOUND_NUMBER = 1;
    public static final int UPPER_BOUND_NUMBER = 45;
    public static final int LOTTO_UNIT = 1000;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        Validator.validateLottoNumber(numbers);
        this.numbers = numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
