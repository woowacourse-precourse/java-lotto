package lotto.domain;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LottoValidationUtils.validate(numbers);
        this.numbers = numbers;
    }

    public int countContainsNumber(Lotto lotto) {
        return (int) numbers.stream()
                .mapToInt(number -> number)
                .filter(lotto::isContains)
                .count();
    }

    public boolean isContains(int number) {
        return numbers.contains(number);
    }
}
