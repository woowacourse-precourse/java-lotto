package lotto;

import java.util.List;
import util.input.lotto.PurchasePriceInputUtil;

public class LottoBuyer {
    private List<Lotto> lottos;
    private int purchasePrice;

    public LottoBuyer() {
        purchasePrice = PurchasePriceInputUtil.getPurchasePrice();
    }
}
