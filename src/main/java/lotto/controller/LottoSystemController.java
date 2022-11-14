package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoVendingMachine;
import lotto.domain.WinningNumbers;
import lotto.domain.WinningResultCalculator;
import lotto.view.inputView.InputView;
import lotto.view.inputView.InputViewImple;
import lotto.view.outputView.OutputView;
import lotto.view.outputView.OutputViewImple;

import java.util.List;


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
        outputView.printWinningStatus(winningResultCalculator.createWinningStatus(lottos, createdWinningNumbers));
        outputView.printReturnRatio(winningResultCalculator.calculateReturnRatio(expenses));
    }

}

