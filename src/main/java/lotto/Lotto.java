package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
//        numbersSorting(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        Exception.isAllDifferentValuesNumber(numbers);
    }

    // TODO : 객체의 로또 번호를 오름차순으로 정렬 후 호출한다.
    public List<Integer> getNumbers() {
        List<Integer> sortingNumbers = new ArrayList<>(numbers);
        Collections.sort(sortingNumbers);
        return sortingNumbers;
    }
}
