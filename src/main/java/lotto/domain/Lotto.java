package lotto.domain;

import java.util.List;

public class Lotto { // 로또 번호 세트 하나에 대한 기능 클래스
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }
    private void validate(List<Integer> numbers) { // 6개가 맞는지
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

}
