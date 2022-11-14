package lotto.domain;

import java.util.List;

import static lotto.constant.ConstValue.*;
import static lotto.constant.Message.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }


    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return numbers;
    }
}
