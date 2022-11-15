package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        checkDuplicate(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    private void checkDuplicate(List<Integer> numbers) {
        boolean[] visitNumbers = new boolean[46];
        Arrays.fill(visitNumbers, false);
        for (int number : numbers) {
            if (visitNumbers[number]) {
                throw new IllegalArgumentException();
            }
            visitNumbers[number] = true;
        }
    }
    public List<Integer> getNumbers() {
        return new ArrayList<>(this.numbers);
    }
}
