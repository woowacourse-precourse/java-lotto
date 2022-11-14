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
        List<Integer> dupleCheck  = new ArrayList<>();
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        for (int idx =0; idx <numbers.size();idx++) {
            if (dupleCheck.contains(numbers.get(idx))) {
                throw new IllegalArgumentException();
            }
            else if (numbers.get(idx)< 1 || numbers.get(idx) > 45) {
                throw new IllegalArgumentException();
            }
            dupleCheck.add(numbers.get(idx));
        }
    }

    // TODO: 추가 기능 구현
}
