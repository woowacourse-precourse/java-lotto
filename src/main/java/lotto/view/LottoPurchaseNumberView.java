package lotto.view;

import lotto.vo.Lotto;
import java.util.List;

public class LottoPurchaseNumberView extends View {
    private final List<Lotto> purchaseLotteries;
    public LottoPurchaseNumberView(List<Lotto> purchaseLotteries) {
        this.purchaseLotteries = purchaseLotteries;
    }

    @Override
    public void show() {
        printLineFormat("%s개를 구매했습니다.", this.purchaseLotteries.size());
        printLine("");

        for (Lotto lotto : this.purchaseLotteries) {
            printLine(lotto.toString());
        }
        printLine("");
    }
}
