package lotto.model;

import lotto.validator.LottoNumberValidator;


import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        new LottoNumberValidator().validateLottoNumbers(numbers);
        this.numbers = sortedNumbers(numbers);
    }

    private List<Integer> sortedNumbers(List<Integer> numbers) {
        List<Integer> sortedNumbers = new ArrayList<>();
        sortedNumbers.addAll(0, numbers);
        sortedNumbers.sort(null);
        return sortedNumbers;
    }

    public List<Integer> getLotto() {
        return this.numbers;
    }
    // TODO: 추가 기능 구현
}
