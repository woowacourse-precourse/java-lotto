package lotto.controller;

import lotto.model.BuyAmount;
import lotto.model.LottoList;
import lotto.model.Result;
import lotto.model.UserNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {

    public LottoGameController() {
        gameStart();
    }

    private void gameStart() {
        BuyAmount buyAmount = new BuyAmount(InputView.buyAmountInput());
        LottoList lottoList = new LottoList(buyAmount.getMONEY());
        initMessage(lottoList);
        UserNumbers userNumbers = new UserNumbers(
            InputView.answerNumberInput(),
            InputView.bonusNumberInput());
        Result result = new Result(lottoList, userNumbers);
        OutputView.ResultPrint(result);
        OutputView.YieldPrint(result.getSumPrice(), buyAmount.getMONEY());
    }

    private void initMessage(LottoList lottoList) {
        OutputView.LottoCountPrint(lottoList.getLOTTO_COUNT());
        OutputView.LottoListPrint(lottoList);
    }


}
