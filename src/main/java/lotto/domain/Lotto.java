package lotto.domain;

import lotto.Validator;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Validator validator = new Validator();
        validator.checkNumAll(numbers);
    }

    private void initNumbers(List<Integer> numbers){
        numbers = new ArrayList<>();
    }


    // TODO: 추가 기능 구현
}
