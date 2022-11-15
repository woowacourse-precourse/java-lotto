package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkOverlap(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현

    private void checkOverlap(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++){
            for(int j = i+1; j < numbers.size(); j++){
                if (numbers.get(i) == numbers.get(j)) throw new IllegalArgumentException();
            }
        }
    }
}
