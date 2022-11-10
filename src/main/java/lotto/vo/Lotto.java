package lotto.vo;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto() {
        this.numbers = List.of(1, 2, 3, 4, 5, 6); //TODO - 번호 자동 선택

    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        return ""; //TODO - [1, 2, 3, 4, 5, 6] 형태로 반환
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
}
