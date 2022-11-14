package lotto.domain;

import java.util.List;

public class WinningNumbers {
    private final List<Integer> mainDraw;
    private final int bonus;

    public WinningNumbers(List<Integer> mainDraw, int bonus) {
        Validator.validate(mainDraw);
        validateBonusNumber(mainDraw, bonus);
        this.mainDraw = mainDraw;
        this.bonus = bonus;
    }

    private void validateBonusNumber(List<Integer> mainDrawNumbers, int bonus) {
        isBonusNumberUnique(mainDrawNumbers, bonus);
        isBonusNumberInRange(bonus);
    }

    private void isBonusNumberUnique(List<Integer> mainDrawNumbers, int bonus) {
        if (mainDrawNumbers.contains(bonus)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복이 없어야 합니다");
        }
    }

    private void isBonusNumberInRange(int bonus) {
        if (bonus < LottoRule.MIN_NUMBER || bonus > LottoRule.MAX_NUMBER) {
            throw new IllegalArgumentException(
                    "보너스 번호는 " + LottoRule.MIN_NUMBER + "보다 크거나 같고 " + LottoRule.MAX_NUMBER + "보다 작거나 같아야 합니다.");
        }
    }

    public boolean mainDrawContains(int number) {
        return mainDraw.contains(number);
    }

    public boolean isEqualToBonusNumbers(int number) {
        return number == bonus;
    }

}
