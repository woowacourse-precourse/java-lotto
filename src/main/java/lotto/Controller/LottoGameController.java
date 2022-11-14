package lotto.Controller;

import lotto.Domain.LottoPublisher;
import lotto.View.InputView;
import lotto.View.OutputView;

public class LottoGameController {

    InputView inputView;
    LottoPublisher lottoPublisher;
    OutputView outputView;

    public void gameStart() {
        purchaseLotto();
    }

    public void purchaseLotto() {
        String purchasing = inputView.inputPurchasing();
        int purchase = Integer.parseInt(purchasing);
        outputView.printEmptyLine();
        int NumberOfLotto = lottoPublisher.calculateNumberOfLotto(purchase);
        outputView.printTheNumberOfLotto(NumberOfLotto);
        outputView.printLottoNumber(NumberOfLotto);
    }
}
