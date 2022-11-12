package lotto.Model;

import lotto.Service.LottoValidator;

import java.util.List;

public class Lotto {

    private static LottoValidator lottoValidator = new LottoValidator();
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        lottoValidator.validate(numbers);
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
