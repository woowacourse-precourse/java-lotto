package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoManager {
    public Lotto issue() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(Lotto.START_RANGE, Lotto.END_RANGE, Lotto.NUMBER_COUNT);
        Lotto lotto = new Lotto(numbers);
        return lotto;
    }

    public boolean hasBonusNumber(Lotto lotto, int bonusNumber) {
        for (int myNum : lotto.getNumbers()) {
            if (myNum == bonusNumber) {
                return true;
            }
        }
        return false;
    }

    public int getMatchCount(Lotto lotto, List<Integer> winningNumbers) {
        int matchCount = 0;
        for (int myNum : lotto.getNumbers()) {
            if (winningNumbers.contains(myNum)) {
                matchCount++;
            }
        }
        return matchCount;
    }
}
