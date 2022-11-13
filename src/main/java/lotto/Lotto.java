package lotto;

import java.util.List;

public class Lotto {//예외처리 및 통합구간 why? Lotto의 매개변수로 number을 받아와야 하는게 선제되니까
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    // TODO: 추가 기능 구현

}
