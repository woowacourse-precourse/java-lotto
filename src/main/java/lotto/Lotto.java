package lotto;

import java.util.List;

/**
 * - `Lotto`에 매개 변수가 없는 생성자를 추가할 수 없다.
 * - `numbers`의 접근 제어자인 private을 변경할 수 없다.
 * - `Lotto`에 필드(인스턴스 변수)를 추가할 수 없다.
 */
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
    }

    // TODO: 추가 기능 구현
}
