package lotto;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        ascendingOrder(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoPublisher.lottoNum) {
            throw new IllegalArgumentException();
        }
        if(numbers.stream().distinct().count() != LottoPublisher.lottoNum){
            throw new IllegalArgumentException();
        }
    }

    private void ascendingOrder(List<Integer> numbers){
        Collections.sort(numbers);
    }

    // TODO: 추가 기능 구현
}
