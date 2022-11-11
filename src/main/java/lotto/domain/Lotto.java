package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.valid.Validation;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Validation.isGeneratedNumberValid(numbers);
    }

    // TODO: 추가 기능 구현


    public List<Integer> getNumbers() {
        return numbers;
    }



}
