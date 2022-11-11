package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoShop {
    private static final int LOTTO_PRICE = 1_000;
    private static final int ZERO = 0;

    public static List<Lotto> purchase(Money money) {
        List<Lotto> lottos = new ArrayList<>();
        while (money.getAmount() != ZERO) {
            lottos.add(issueLotto());
            money.decreaseAmount(LOTTO_PRICE);
        }
        return lottos;
    }

    private static Lotto issueLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }
}
