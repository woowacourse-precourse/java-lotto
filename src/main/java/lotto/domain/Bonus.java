package lotto.domain;

import java.util.List;
import java.util.regex.Pattern;

public class Bonus {
    private final int bonusNumber;

    public Bonus(int bonusNumber, Lotto winningLotto) throws IllegalArgumentException {
        validateBonusDuplication(winningLotto, bonusNumber);
        validateBonusRange(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public static void bonusIsNumeric(String bonusNumber) throws IllegalArgumentException {
        String pattern = "^[0-9]*$";
        if (!Pattern.matches(pattern, bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 양의 정수 형태이어야 합니다.");
        }
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }

    private void validateBonusDuplication(Lotto winningLotto,
                                          int bonusNumber) throws IllegalArgumentException {
        List<Integer> lottoNumbers = winningLotto.getLotto();
        if (lottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 담첨 번호와 중복될 수 없습니다.");
        }
    }

    private void validateBonusRange(int bonusNumber) throws IllegalArgumentException {
        if (!(1 <= bonusNumber && bonusNumber <= 45)) {
            throw new IllegalArgumentException("[ERROR} 보너스 번호의 범위는 1 ~ 45 사이어야만 합니다.");
        }
    }
}
