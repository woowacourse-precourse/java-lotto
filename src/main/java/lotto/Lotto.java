package lotto;

import org.mockito.internal.matchers.Null;

import java.util.List;

public class Lotto {
    private static final int MAX_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != MAX_SIZE) {
            throw new IllegalArgumentException();
        }
        if(numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException();
        }

        if(numbers.stream().filter(n -> n < 1 || n > 45).findFirst() != null) {
            throw new IllegalArgumentException();
        }
    }



    // TODO: 추가 기능 구현
}
