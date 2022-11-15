package lotto.Controller;

import lotto.Domain.LottoPublisher;
import lotto.Domain.PurchasingLotto;
import lotto.View.InputView;
import lotto.View.OutputView;

public class LottoGameController {

    InputView inputView;
    OutputView outputView;
    PurchasingLotto purchasingLotto;

    public void gameStart() {
        purchaseLotto();
    }

    public void purchaseLotto() {
        int purchasing = inputView.inputPurchasing();
        outputView.printEmptyLine();
        new PurchasingLotto(purchasing);
        outputView.printTheNumberOfLotto(purchasingLotto.getAmountOfLotto());
        outputView.printLottoNumber(purchasingLotto.getPurchase());
    }
}
