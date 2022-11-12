package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public int getCountMatchingNumber(List<Integer> numbers) {
        int count = 0;

        for (Integer number : numbers) {
            if(this.numbers.contains(number)) {
                count++;
            }
        }

        return count;
    }

    public boolean hasNumber(int number) {
        if(numbers.contains(number)) return true;
        return false;
    }

    public String toString() {
        Collections.sort(numbers);
        return numbers.toString();
    }
}
