package lotto;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        ascendingSort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호의 개수가 맞지 않습니다.");
        }
    }

    private void ascendingSort(List<Integer> numbers){
        Collections.sort(numbers);
    }

    public List<Integer> getNumbers(){
        return numbers;
    }
}
