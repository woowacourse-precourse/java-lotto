package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoShop {
    private static final int LOTTO_PRICE = 1_000;

    public static List<Lotto> purchase(int money) {
        List<Lotto> lottos = new ArrayList<>();
        int purchaseQuantity = money / LOTTO_PRICE;
        while (lottos.size() < purchaseQuantity) {
            lottos.add(issueLotto());
        }
        return lottos;
    }

    private static Lotto issueLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }
}
