package lotto.vo;

import lotto.system.validator.ConvertingToLottoValidator;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        numbers = new ArrayList<>(numbers);
        ConvertingToLottoValidator.validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    public boolean contains(Integer target) {
        return numbers.contains(target);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
