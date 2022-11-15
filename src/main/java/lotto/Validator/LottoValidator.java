package lotto.Validator;

import lotto.Domain.Lotto;

public class LottoValidator {
    public static boolean checkLottoRange(int num) {
        if (num < 1 || num > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45사이의 숫자여야합니다.");
        }
        return true;
    }

    public static void validateBonusNumber(Lotto winningNumber, int bonusNumber) {
        checkBonusContain(winningNumber, bonusNumber);
        checkBonusRange(bonusNumber);
    }

    public static void checkBonusContain(Lotto winningNumber, int bonusNumber) {
        if (winningNumber.isContain(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR} 보너스 번호는 당첨 번호에 포함되어 있지 않아야 합니다.");
        }
    }

    public static void checkBonusRange(int bonusNumber) {
        if (bonusNumber < 1 || 45 < bonusNumber) {
            throw new IllegalArgumentException("[ERROR} 보너스 번호는 1~45사이의 숫자여야 합니다.");
        }
    }
}
