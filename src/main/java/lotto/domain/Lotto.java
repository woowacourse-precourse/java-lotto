package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;        // 접근 제어자 수정 금지
    // 필드 추가 금지
    public Lotto(List<Integer> numbers) {       // 디폴트 생성자 사용 금지
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    // TODO: 추가 기능 구현
}
