package lotto;

import java.util.List;

public class Prize extends Lotto{
    private Integer bonusNumber;

    public Prize(List<Integer> numbers, Integer bonusNumber) {
        super(numbers);
        validateBonusNumber(numbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public Prize(List<Integer> numbers) {
        super(numbers);
    }

    private void validateBonusNumber(List<Integer> numbers, Integer bonusNumber) {
        if(numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 당첨 번호와 중복");
        }
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }

    public void setBonusNumber(Integer bonusNumber) {
        validateBonusNumber(this.getNumbers(), bonusNumber);
        this.bonusNumber = bonusNumber;
    }
}
