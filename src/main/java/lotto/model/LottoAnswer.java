package lotto.model;

import java.util.List;

public class LottoAnswer extends Lotto {
    private final Integer bonusNumber;

    public LottoAnswer(List<Integer> numbers, Integer bounsNumber) {
        super(numbers);
        validate(numbers);
        this.bonusNumber = bounsNumber;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoEnum.SIZE.getValue()) {
            throw new IllegalArgumentException("입력한 값이 " + LottoEnum.SIZE + "자리보다 작거나 큽니다!");
        }
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
