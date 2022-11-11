package lotto.domain;

import lotto.validate.LottoValidate;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
       LottoValidate lottoValidate = new LottoValidate();
       lottoValidate.validate(numbers);
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers(){
        return numbers;
    }
}
