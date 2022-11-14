package lotto.domain.lotto.domain;

import lotto.domain.lotto.verifier.InputNumberVerifier;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
    }

    private void validate(List<Integer> numbers) {
        InputNumberVerifier.prizeNumberVerifier(numbers);
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return numbers;
    }
}
