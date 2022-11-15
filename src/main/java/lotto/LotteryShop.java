package lotto;

import java.util.ArrayList;
import java.util.List;

public class LotteryShop {

    private List<Lotto> purchaseLotto(Money money) {
        int lottoPurchaseAmount = money.getLottoPurchaseAmount();
        List<Lotto> purchasedLotto = new ArrayList<>();
        while (lottoPurchaseAmount-- > 0) {
            purchasedLotto.add(Lotto.generateRandomLotto());
        }
        return purchasedLotto;
    }
}
