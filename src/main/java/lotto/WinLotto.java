package lotto;

import constant.Text;

import java.util.List;

public class WinLotto extends Lotto {
    private final int bonusNumber;

    public WinLotto(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        this.bonusNumber = bonusNumber;
        validate(numbers, bonusNumber);
    }

    private void validate(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(
                    Text.ERROR + "보너스 번호가 당첨 번호와 중복되었습니다.");
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
