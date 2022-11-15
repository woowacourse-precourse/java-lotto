package lotto;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
        Collections.sort(this.numbers);
    }

    // TODO: 추가 기능 구현
}
