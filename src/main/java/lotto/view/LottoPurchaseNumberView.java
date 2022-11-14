package lotto.view;

import lotto.model.Lotto;
import lotto.util.Lang;

import java.util.List;

public class LottoPurchaseNumberView extends View {
    private final List<Lotto> purchaseLotteries;
    public LottoPurchaseNumberView(List<Lotto> purchaseLotteries) {
        this.purchaseLotteries = purchaseLotteries;
    }

    @Override
    public void show() {
        printLine(Lang.format(Lang.VIEW_SUCCESS_BUY, this.purchaseLotteries.size()));
        printLine("");

        for (Lotto lotto : this.purchaseLotteries) {
            printLine(lotto.toString());
        }
        printLine("");
    }
}
