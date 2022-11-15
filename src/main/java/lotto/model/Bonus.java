package lotto.model;

import static lotto.utils.ConstantUtil.ERROR;

import java.util.List;
import java.util.Objects;

public class Bonus {
    private static final String BONUS_ERROR_MESSAGE = ERROR + "보너스 번호는 당첨 번호와 중복될 수 없습니다.";

    private final int bonusNumber;

    public Bonus(int bonusNumber, Lotto winningLotto) {
        validate(bonusNumber, winningLotto);
        this.bonusNumber = bonusNumber;
    }

    public boolean isMatch(List<Integer> numbers) {
        return numbers.contains(bonusNumber);
    }

    private void validate(int bonusNumber, Lotto winningLotto) {
        validateBonusNumber(bonusNumber, winningLotto);
    }

    private void validateBonusNumber(int bonusNumber, Lotto winningLotto) {
        if (winningLotto.isExistNumber(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_ERROR_MESSAGE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Bonus bonus = (Bonus) o;
        return bonusNumber == bonus.bonusNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bonusNumber);
    }
}
