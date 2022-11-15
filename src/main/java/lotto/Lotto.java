package lotto;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        numbersSorting(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO : 객체의 로또 번호를 호출한다.
    public List<Integer> getNumbers() {
        return numbers;
    }

    // TODO : 객체의 로또 번호를 오름차순으로 정렬한다.
    private void numbersSorting(List<Integer> numbers){
        Collections.sort(numbers);
    }

}
