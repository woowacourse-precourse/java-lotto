package lotto;

import java.util.HashSet;
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
}
