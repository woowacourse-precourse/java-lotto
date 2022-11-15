package lotto;

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
    }

    private void ascendingOrder(List<Integer> numbers){
        numbers.sort(Integer::compareTo);
    }

    // TODO: 추가 기능 구현
}
