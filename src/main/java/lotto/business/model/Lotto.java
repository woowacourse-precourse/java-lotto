package lotto.business.model;

import java.util.List;
import lotto.service.ValidInput;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        ValidInput.validInputHasDuplicatedNumber(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoEnum.SIZE.getValue()) {
            throw new IllegalArgumentException("입력한 값이 " + LottoEnum.SIZE + "자리보다 작거나 큽니다!");
        }
    }



    public List<Integer> getLottoNumber() {
        return numbers;
    }

    public String toString() {
        return numbers.toString();
    }
}
