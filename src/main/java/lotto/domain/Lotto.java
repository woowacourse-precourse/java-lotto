package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateOverlapNumbers(numbers);
        validateNumbersRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현

    private void validateOverlapNumbers(List<Integer> numbers) {
        numbers.stream().distinct().collect(Collectors.toList());
        if (numbers.size() != 6) {
            System.out.println("[ERROR] 로또 번호는 중복이 불가합니다.");
            throw new IllegalArgumentException();
        }
    }

    private void validateNumbersRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            checkRange(number);
        }
    }

    private void checkRange(int number) {
        if (number < 1 || number > 45) {
            System.out.println("[ERROR] 로또 번호는 1부터 45사이여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getLotto() {
        return numbers;
    }
}
