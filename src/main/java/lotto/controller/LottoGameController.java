package lotto.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.model.BuyAmount;
import lotto.model.Lotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {

    public LottoGameController() {

        BuyAmount buyAmount = new BuyAmount(InputView.buyAmountInput());
        LottoListController lottoGameController = new LottoListController(buyAmount.getMONEY());
        OutputView.LottoCountPrint(lottoGameController.getLOTTO_COUNT());
        OutputView.LottoListPrint(lottoGameController);


    }


}
