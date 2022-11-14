package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LotteryShop {
    private static final int LOTTO_PRICE = 1000;

    public int countLotto(int amount) {
        validate(amount);
        return amount / LOTTO_PRICE;
    }

    public List<Integer> makeLotto() {
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(numbers);
        return numbers;
    }

    private void validate(int amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 1000단위로 입력해 주세요.");
        }
        if (amount - LOTTO_PRICE < 0) {
            throw new IllegalArgumentException("[ERROR] 금액이 부족합니다.");
        }
    }
}
