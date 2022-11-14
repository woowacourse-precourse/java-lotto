package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
        validateSize();
        validateDuplicate();
        validateRange();

    }

    private void validateSize() {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("당첨번호는 6개의 숫자를 입력하셔야 합니다.");
        }
    }

    private void validateDuplicate() {
        int numbersLength = (int) numbers.stream()
                .distinct()
                .count();
        if (numbersLength != 6) {
            throw new IllegalArgumentException("당첨번호는 중복번호를 입력할 수 없습니다.");
        }
    }

    private void validateRange() {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("당첨번호는 1부터 45까지의 수여야 합니다.");
            }
        }
    }


}
