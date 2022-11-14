package lotto.model;

import lotto.validator.LottoNumberValidator;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        new LottoNumberValidator().validateLottoNumbers(numbers);
        this.numbers = sortedNumbers(numbers);
    }

    private List<Integer> sortedNumbers(List<Integer> numbers) {
        return numbers.stream()
                .sorted(Integer::compareTo)
                .collect(Collectors.toList());
    }

    public List<Integer> getLotto() {
        return this.numbers;
    }
    // TODO: 추가 기능 구현
}
