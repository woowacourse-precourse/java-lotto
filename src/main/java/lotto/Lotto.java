package lotto;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    public List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {

//        Collections.sort(numbers); // 포함하면 오류남
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Error.CountError.print());
        }
        for (int a : numbers) {
            if (a < 1 || a > 45) {
                throw new IllegalArgumentException(Error.RangeError.print());
            }
            if (numbers.size() != numbers.stream().distinct().count()) {
                throw new IllegalArgumentException(Error.MultiError.print());
            }
        }

    }

    private void sort(List<Integer> numbers) {
        numbers.stream().sorted().collect(Collectors.toList());
    }

}
