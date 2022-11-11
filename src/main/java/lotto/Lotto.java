package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Validate checkNumber = new Validate();
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 번호 6개를 입력하세요.");
        }
        checkNumber.validUserWinningNumber(numbers);
    }

    // TODO: 추가 기능 구현
}
