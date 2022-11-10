package lotto;

import java.util.List;

public class WinningNumbers {
    private final List<Integer> mainDraw;
    private final int bonus;

    public WinningNumbers(List<Integer> mainDrawNumbers, int bonus) {
        Validator.validate(mainDrawNumbers);
        validateBonusNumber(mainDrawNumbers, bonus);
        this.mainDraw = mainDrawNumbers;
        this.bonus = bonus;
    }

    private void validateBonusNumber(List<Integer> mainDrawNumbers, int bonus) {
        isBonusNumberUnique(mainDrawNumbers, bonus);
        isBonusNumberInRange(bonus);
    }

    private void isBonusNumberUnique(List<Integer> mainDrawNumbers, int bonus) {
        if (mainDrawNumbers.contains(bonus)) {
            throw new IllegalArgumentException("[ERROR]bonus number is not unique");
        }
    }

    private void isBonusNumberInRange(int bonus) {
        if (bonus < LottoRule.MIN_NUMBER || bonus > LottoRule.MAX_NUMBER) {
            throw new IllegalArgumentException("[ERROR]bonus number is out of range");
        }
    }

    public boolean contains(int number) {
        return mainDraw.contains(number);
    }

    public boolean isEqualToBonusNumbers(int number) {
        return number == bonus;
    }

}
