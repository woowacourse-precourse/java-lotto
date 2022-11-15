package lotto.domain;

import java.util.Collections;
import java.util.List;

import static lotto.util.ValidUtil.validateDuplication;
import static lotto.util.ValidUtil.validateNumberUnit;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumberUnit(numbers);
        validateDuplication(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }


    // TODO: 추가 기능 구현
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");

        for (int i = 0; i < numbers.size()-1; i++) {
            builder.append(numbers.get(i) + ", ");
        }
        builder.append(numbers.get(numbers.size() - 1) + "]");

        return builder.toString();
    }

}
