package lotto;

import lotto.io.View;

public class LottoProgram {
    private final View view;

    public LottoProgram(View view) {
        this.view = view;
    }

    public void run() {
        view.requestPurchaseAmount();
        String purchaseAmount = view.getPurchaseAmount();
    }
}
