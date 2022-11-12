package lotto.domain;

import java.util.ArrayList;
import java.util.List;

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
}
