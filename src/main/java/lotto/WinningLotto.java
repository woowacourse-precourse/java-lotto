package lotto;

import java.util.List;

public class WinningLotto extends Lotto {

    private final Integer bonusNumber;

    public WinningLotto(List<Integer> numbers, Integer bonusNumber) {
        super(numbers);
        validate(numbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(List<Integer> numbers, Integer bonusNumber) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }

        validateBonusNumber(bonusNumber);
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateBonusNumber(Integer bonusNumber) {

        if (bonusNumber <= 0) {
            throw new IllegalArgumentException("0이하의 숫자는 당첨번호가 될 수 없습니다.");
        }

        if (bonusNumber > 45) {
            throw new IllegalArgumentException("45보다 큰 숫자는 당첨번호가 될 수 없습니다.");
        }
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
