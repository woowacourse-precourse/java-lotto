package domain.Bonus;

import domain.Lotto.Lotto;

import java.util.regex.Pattern;

public class BonusController {
    private static final String FORMAT = "^\\d*$";
    private final BonusService bonusService = new BonusService();

    public void validateFormat(String bonusNumber) {
        if (!Pattern.matches(FORMAT, bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 공백이 포함되지 않은 자연수 하나만 입력해야 합니다.");
        }
    }

    public Bonus createBonus(String bonusNumber, Lotto lotto) {
        validateFormat(bonusNumber);
        return bonusService.createBonus(bonusNumber, lotto);
    }
}
