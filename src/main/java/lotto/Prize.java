package lotto;

import java.util.List;

public class Prize extends Lotto{
    private final Integer bonusNumber;

    public Prize(List<Integer> numbers, Integer bonusNumber) {
        super(numbers);
        validateBonusNumber(numbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(List<Integer> numbers, Integer bonusNumber) {
        if(numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 당첨 번호와 중복");
        }
    }
}
