package lotto;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSixNumbers(numbers);
        validateDuplicate(numbers);
        validateNumberRange(numbers);
    }

    // TODO: 추가 기능 구현

    private  void validateSixNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개의 숫자를 입력해야 합니다.");
        }
    }
    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> numSet = new HashSet<>(numbers);
        if (numbers.size() != numSet.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 있습니다.");
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) > 45 || numbers.get(i) < 1)
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public void sort() {
        Collections.sort(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
