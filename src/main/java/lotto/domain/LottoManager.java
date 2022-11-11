package lotto.domain;

import lotto.view.InputView;

public class LottoManager {
    private int purchaseAmount;
    private int lottoIssueCount;

    private void savePurchaseAmount() {
        this.purchaseAmount = InputView.enterPurchaseAmount();
    }
    private void saveLottoIssueCount() {
        this.lottoIssueCount = purchaseAmount / 1000;
    }

}
