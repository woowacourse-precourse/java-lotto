package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class Lotto {

    private final List<Integer> numbers;

    private Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Lotto create() {
        List<Integer> randomNumbers = LottoGenerator.createRandomLottoNumber();
        return new Lotto(randomNumbers);
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    @Override
    public String toString() {
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList()).toString();
    }
}
