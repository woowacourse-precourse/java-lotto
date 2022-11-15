package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6 ) {
            throw new IllegalArgumentException("[ERROR] 로또 번호 오류");
        }
    }


    // TODO: 추가 기능 구현
}
