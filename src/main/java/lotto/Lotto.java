package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ExceptionCode.Not_Size.message);
        }
        if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException(ExceptionCode.Exists_Number.message);
        }
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) < 1 || numbers.get(i) > 46) {
                throw new IllegalArgumentException(ExceptionCode.Over_Range_Number.message);
            }
        }
    }
    public List<Integer> getNumbers() {
        return numbers;
    }

}
