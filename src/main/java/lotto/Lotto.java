package lotto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static lotto.exception.Exception.catchDuplicatedException;
import static lotto.exception.Exception.catchWrongCountNumberException;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        catchWrongCountNumberException(numbers);
        catchDuplicatedException(numbers);
        this.numbers = numbers;
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
