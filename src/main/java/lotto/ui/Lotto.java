package lotto.ui;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        rangeValid(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    private void rangeValid(List<Integer> numbers){
        for (int i=0;i<6;i++){
            if (1>numbers.get(i) || numbers.get(i)>45){
                throw new IllegalArgumentException();
            }
        }
    }
}
