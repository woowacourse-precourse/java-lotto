package lotto.controller;

import lotto.model.BuyAmount;
import lotto.model.LottoGroup;
import lotto.model.Result;
import lotto.model.UserLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {

    public LottoGameController() {
        gameStart();
    }

    private void gameStart() {
        try {
            BuyAmount buyAmount = new BuyAmount(InputView.buyAmountInput());
            LottoGroup lottoGroup = new LottoGroup(buyAmount.getMONEY());
            initMessage(lottoGroup);
            UserLotto userLotto = new UserLotto(InputView.answerNumberInput(), InputView.bonusNumberInput());
            Result result = new Result(lottoGroup, userLotto);
            finishMessage(result, buyAmount);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void initMessage(LottoGroup lottoGroup) {
        OutputView.LottoCountPrint(lottoGroup.getLOTTO_COUNT());
        OutputView.LottoListPrint(lottoGroup);
    }

    private void finishMessage(Result result, BuyAmount buyAmount) {
        OutputView.ResultPrint(result);
        OutputView.YieldPrint(result.getSumPrice(), buyAmount.getMONEY());
    }


}
