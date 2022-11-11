package lotto.controller;

import lotto.model.BuyAmount;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {

    public LottoGameController() {

        BuyAmount buyAmount = new BuyAmount(InputView.buyAmountInput());
        LottoListController lottoGameController = new LottoListController(buyAmount.getMONEY());
        OutputView.LottoCountPrint(lottoGameController.getLOTTO_COUNT());
        OutputView.LottoListPrint(lottoGameController);
        String usernumbers = InputView.answerNumberInput();
        String userbonusnumber = InputView.bonusNumberInput();
        UserNumbersController userNumbersController = new UserNumbersController(usernumbers,
            userbonusnumber);


    }


}
