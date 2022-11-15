package lotto.business.model;

import java.util.List;

public class LottoAnswer extends Lotto {
    private final Integer bonusNumber;

    public LottoAnswer(List<Integer> numbers, Integer bounsNumber) {
        super(numbers);
        validate(numbers);
        validIsBonusNumberDuplicated(numbers, bounsNumber);
        this.bonusNumber = bounsNumber;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoEnum.SIZE.getValue()) {
            throw new IllegalArgumentException("[ERROR] 입력한 값이 " + LottoEnum.SIZE + "자리보다 작거나 큽니다!");
        }
    }

    private void validIsBonusNumberDuplicated(List<Integer> numbers, Integer bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호로 입력한 값이 기존에 존재합니다!");
        }
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
