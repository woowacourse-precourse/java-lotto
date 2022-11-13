package lotto.domain;

import lotto.valid.LottoValidator;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LottoValidator.validate(numbers);
        this.numbers = numbers;
    }

    // TODO: 추가 기능 구현

    @Override
    public String toString(){
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList())
                .toString();
    }
}
