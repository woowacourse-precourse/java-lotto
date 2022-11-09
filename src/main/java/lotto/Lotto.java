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
            throw new IllegalArgumentException();
        }
        // 당첨 결과가 유효하면 구매한 로또와 당첨결과를 비교
        // 당첨결과 출력
    }

    // TODO: 추가 기능 구현
}
