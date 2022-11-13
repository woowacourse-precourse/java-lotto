package lotto.model;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("당첨번호는 6개의 숫자를 입력하셔야 합니다.");
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        int numbersLength = (int) numbers.stream()
                .distinct()
                .count();
        if (numbersLength != 6) {
            throw new IllegalArgumentException("당첨번호는 중복번호를 입력할 수 없습니다.");
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("당첨번호는 1부터 45까지의 수여야 합니다.");
            }
        }
    }


}
