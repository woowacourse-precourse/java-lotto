package lotto.Validator;

import java.util.HashSet;
import lotto.Domain.Lotto;
import org.assertj.core.util.Sets;

public class LottoValidator {
    public static boolean checkLottoRange(int num) {
        if (num < 1 || num > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45사이의 숫자여야합니다.");
        }
        return true;
    }

    public static void validateWinningNumber(Lotto lotto) {
        checkWinningLength(lotto);
        checkWinningRange(lotto);
        checkWinningEachDifferent(lotto);
    }

    public static void validateBonusNumber(Lotto winningNumber, int bonusNumber) {
        checkBonusContain(winningNumber, bonusNumber);
        checkBonusRange(bonusNumber);
    }

    public static void checkWinningLength(Lotto lotto) {
        if (lotto.size() != 6) {
            throw new IllegalArgumentException("[ERROR} 당첨 번호는 총 6개여야합니다. ");
        }
    }

    public static void checkWinningRange(Lotto lotto) {
        for (int i = 0; i < 6; i++) {
            if (lotto.getNumbers().get(i) < 1 || 45 < lotto.getNumbers().get(i)) {
                throw new IllegalArgumentException("[ERROR} 당첨 번호는 1~45사이의 숫자여야 합니다.");
            }
        }
    }

    public static void checkWinningEachDifferent(Lotto lotto) {
        HashSet<Integer> setNum = Sets.newHashSet(lotto.getNumbers());

        if (setNum.size() != lotto.size()) {
            throw new IllegalArgumentException("[ERROR} 당첨 번호는 모두 달라야 합니다.");
        }
    }

    public static void checkBonusContain(Lotto winningNumber, int bonusNumber) {
        if (winningNumber.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR} 보너스 번호는 당첨 번호에 포함되어 있지 않아야 합니다.");
        }
    }

    public static void checkBonusRange(int bonusNumber) {
        if (bonusNumber < 1 || 45 < bonusNumber) {
            throw new IllegalArgumentException("[ERROR} 보너스 번호는 1~45사이의 숫자여야 합니다.");
        }
    }
}
