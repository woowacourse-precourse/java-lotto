package lotto;

import java.util.List;
import java.util.Set;

public class Lotto {

    private static final String OVERSIZELOTTO_ERRORMESSAGE = "[ERROR] 6개의 숫자만 입력해주세요";
    private static final String DUPLICATELOTTO_ERRORMESSAGE = "[ERROR] 중복된 숫자를 입력하지마세요.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(OVERSIZELOTTO_ERRORMESSAGE);
        }
        if (Set.copyOf(numbers).size() != 6) {
            throw new IllegalArgumentException(DUPLICATELOTTO_ERRORMESSAGE);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
