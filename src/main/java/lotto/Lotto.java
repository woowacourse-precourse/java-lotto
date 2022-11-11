package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Lotto {
    private final List<Integer> numbers;
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicatedNumber(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    //중복된 숫자 있으면 에러 발생.
    private void duplicatedNumber(List<Integer> numbers) {
        Set<Integer> DeleteDuplicate = new HashSet<>(numbers);
        if (!(DeleteDuplicate.size() == 6)) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
}
