package lotto.domain.lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final int LOTTO_NUMBERS_SIZE_LIMIT = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumbersByOverSize(numbers);
        validateNumbersByDuplicatedNumber(numbers);
        validateNumbersByNumberRange(numbers);
    }

    private void validateNumbersByOverSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_SIZE_LIMIT) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNumbersByDuplicatedNumber(List<Integer> numbers) {
        Set<Integer> nonDuplicatedNumbers = new HashSet<>(numbers);
        if (nonDuplicatedNumbers.size() != LOTTO_NUMBERS_SIZE_LIMIT) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNumbersByNumberRange(List<Integer> numbers) {
        String expression = "^[1-9]{1}$|^[1-3]{1}[0-9]{1}$|^4{1}[0-5]{1}$";
        for (Integer number : numbers) {
            if (!number.toString().matches(expression)) {
                throw new IllegalArgumentException("[ERROR] 1~45의 범위의 숫자만 입력해주세요.");
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void printNumbers() {
        System.out.println(numbers);
    }
}
