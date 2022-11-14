package lotto.Model;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    // TODO: validate
    /*
        1. size 6개인지 확인
        2. 중복되는 값이 없는지 확인
        3. 1~45 사이의 숫자인지 확인
     */
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
}
