package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            //exception
        }
    }

    // TODO: 추가 기능 구현
    private void validateUnique(List<Integer> numbers) {
        for(int i:numbers) {
            validateLoop(i, numbers);
        }
    }
    private void validateLoop(int i, List<Integer> numbers) {
        for(int j:numbers) {
            isUnique(i, j, numbers);
        }
    }
    private void isUnique(int i, int j, List<Integer> numbers) {
        if(numbers.get(i).equals(numbers.get(j))) {
            //exception
        }
    }
}
