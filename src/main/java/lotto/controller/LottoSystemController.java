package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoVendingMachine;
import lotto.domain.Rank;
import lotto.domain.WinningNumbers;
import lotto.domain.WinningResultCalculator;
import lotto.view.inputView.InputView;
import lotto.view.inputView.InputViewImple;
import lotto.view.outputView.OutputView;
import lotto.view.outputView.OutputViewImple;

import java.util.List;
import java.util.Map;


public class LottoSystemController {
    private LottoVendingMachine lottoVendingMachine = new LottoVendingMachine();
    private WinningNumbers winningNumbers = new WinningNumbers();
    private WinningResultCalculator winningResultCalculator = new WinningResultCalculator();
    private OutputView outputView = new OutputViewImple();
    private InputView inputView = new InputViewImple();

    public void run(){
        try {
            startLottoSystem();
        }catch (Exception e){
            outputView.printErrorMessage(e);
        }
    }

    private void startLottoSystem() {
        Integer expenses = inputView.inputPayment();
        List<Lotto> lottos = lottoVendingMachine.generateLottos(expenses);
        outputView.printPurchasedLottos(lottos);

        List<Integer> rawValuse = inputView.inputWinningNumbers();
        Integer bonusNumber = inputView.inputBonusNumber();
        WinningNumbers createdWinningNumbers = winningNumbers.generateFromRawValues(rawValuse, bonusNumber);

        Map<Rank, Integer> winningStatusResult = winningResultCalculator.generateWinningStatus(lottos,createdWinningNumbers);
        outputView.printWinningStatus(winningStatusResult);
        double returnRatioResult = winningResultCalculator.generateReturnRatio(expenses,winningStatusResult);
        outputView.printReturnRatio(returnRatioResult);
    }

}

