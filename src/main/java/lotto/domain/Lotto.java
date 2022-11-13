package lotto.domain;

import lotto.valid.LottoValidator;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    public static final int NUMBER_SIZE = 6;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LottoValidator.validate(numbers);
        this.numbers = numbers;
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString(){
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList())
                .toString();
    }
}
