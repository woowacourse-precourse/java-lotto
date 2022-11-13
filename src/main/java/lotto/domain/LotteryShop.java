package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LotteryShop {
    private static final int LOTTO_PRICE = 1000;

    private int countLotto(int totalPayment) {
        validate(totalPayment);
        return totalPayment / LOTTO_PRICE;
    }

    public List<Integer> makeLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }

    private void validate(int totalPayment) {
        if (totalPayment % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException();
        }
        if (totalPayment - LOTTO_PRICE < 0) {
            throw new IllegalArgumentException();
        }
    }
}
