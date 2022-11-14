package lotto.game;

import java.util.List;

public class Lotto {
    // 인스턴스 변수 생성 불가능하다. (객체 내에 선언되는 변수, 공유되지 않는 변수)
    private final List<Integer> numbers;

    // 매개 변수가 없는 생성자를 추가할 수 없다.
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
