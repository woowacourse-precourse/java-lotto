package lotto;

import java.util.List;
import util.input.lotto.PurchasePriceInputUtil;

public class LottoBuyer {
    private List<Lotto> lottos;
    private int purchasePrice;

    public LottoBuyer() {
        purchasePrice = PurchasePriceInputUtil.getPurchasePrice();
    }

    public void printAllLottos() {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }

        System.out.println();
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }

    public void setLottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }
}
