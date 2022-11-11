package lotto.controller;

import lotto.model.BuyAmount;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {

    public LottoGameController() {
        gameStart();
    }

    private void gameStart() {
        BuyAmount buyAmount = new BuyAmount(InputView.buyAmountInput());
        LottoListController lottoListController = new LottoListController(buyAmount.getMONEY());
        initMessage(lottoListController);
        UserNumbersController userNumbersController = new UserNumbersController(
            InputView.answerNumberInput(),
            InputView.bonusNumberInput());
        LottoSameCountController lottoSameCountController = new LottoSameCountController(
            lottoListController, userNumbersController);
        OutputView.ResultPrint(lottoSameCountController.getRANK_COUNT_LIST());
        OutputView.YieldPrint(lottoSameCountController.getSUM_MONEY(), buyAmount.getMONEY());
    }

    private void initMessage(LottoListController lottoListController) {
        OutputView.LottoCountPrint(lottoListController.getLOTTO_COUNT());
        OutputView.LottoListPrint(lottoListController);
    }

    private void sameMessage(LottoListController lottoListController,
        UserNumbersController userNumbersController) {

    }


}
