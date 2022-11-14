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
        String purchasing = inputView.inputPurchasing();
        int purchase = Integer.parseInt(purchasing);
        outputView.printEmptyLine();
        int NumberOfLotto = purchasingLotto.calculateNumberOfLotto(purchase);
        outputView.printTheNumberOfLotto(NumberOfLotto);
        outputView.printLottoNumber(NumberOfLotto);
    }
}
