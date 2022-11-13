package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

    public List<Integer> getNumbers(){
        return numbers;
    }
    public List<Integer> sortedNumbers(){
        List<Integer> newNumbers = new ArrayList<>();
        this.numbers.stream().forEach(number-> newNumbers.add(number));
        newNumbers.sort(Comparator.naturalOrder());
        return newNumbers;
    }
}
