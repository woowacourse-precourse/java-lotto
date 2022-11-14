package lotto;

import java.util.Collections;
import java.util.LinkedList;
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
    public void printAscending() {
        List<Integer> numbers = new LinkedList<>(this.numbers);
        System.out.println(numbers.toString());
    }

    public Integer containsN(List<Integer> numbers) {
        int numberOfSame = 0;
        for (Integer number : numbers) {
            if (this.numbers.contains(number)) {
                numberOfSame += 1;
            }
        }
        return numberOfSame;
    }

    public boolean contains(Integer number) {
         return this.numbers.contains(number);
    }
}
