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
            throw new IllegalArgumentException("[ERROR] 로또 번호는 총 6개여야 합니다.");
        }
        if (Validator.isDuplicated(numbers)){
            throw new IllegalArgumentException("[ERROR] 번호는 중복되지 않는 6개의 숫자로 이루어져야 합니다.");
        }
        if (!Validator.isProperRange(numbers, 1,45)){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    // TODO: 추가 기능 구현
}
