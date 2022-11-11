package lotto;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

public class Manager {

    public List<Integer> getRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public int getAmount(int won) {
        if (won % Lotto.PRICE != 0 || won == 0) {
            throw new IllegalArgumentException();
        }
        return won / Lotto.PRICE;
    }
}
