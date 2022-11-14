package controller;

import domain.MatchingNumber;
import domain.WinningNumber;
import lotto.Lotto;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    InputController inputController = new InputController();
    OutputController outputController = new OutputController();

    public void lottoStart() {
        try {
            int lottoPurAmount = inputController.insertLottoAmount();
            OutputView.printBuyLottoNumber(lottoPurAmount);
            List<Lotto> lottos = new ArrayList<>(inputController.makeLottoNumberList(lottoPurAmount));
            OutputView.printAllLottoNumber(lottos);
            WinningNumber winningNumber = new WinningNumber(inputController.insertLottoNumber());

            InputView.printInputBonusNumber();
            int bonusNumber = inputController.insertBonusNumber();
            MatchingNumber matchingNumber = new MatchingNumber(outputController.matchingNumber(lottos,winningNumber.getWinNumbers(),bonusNumber));
            OutputView.printResult(matchingNumber);
            OutputView.printProfit(outputController.winningAmount(matchingNumber),lottoPurAmount);
        }   catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }
}