package lotto.view;

import lotto.model.Lotto;
import lotto.util.Lang;
import java.util.List;

public class LottoPurchaseNumberView extends View {
    private final List<Lotto> lotteries;
    public LottoPurchaseNumberView(List<Lotto> lotteries) {
        this.lotteries = lotteries;
    }

    @Override
    public void show() {
        printLine(Lang.format(Lang.VIEW_SUCCESS_BUY, this.lotteries.size()));
        printLine("");

        for (Lotto lotto : this.lotteries) {
            printLine(lotto.toString());
        }
        printLine("");
    }
}
