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
    private Integer expenses;
    private List<Lotto> purchasedLottos;
    private WinningNumbers createdWinningNumbers;
    private Map<Rank, Integer> winningStatusResult;
    private double returnRatioResult;

    public void run(){
        try {
            startLottoSystem();
        }catch (Exception e){
            outputView.printErrorMessage(e);
        }
    }

    private void startLottoSystem() {
        purchaseLottos();
        inputWinningNumbers();
        showWinningResult();
    }

    private void purchaseLottos(){
        expenses = inputView.inputPayment();
        purchasedLottos = lottoVendingMachine.generateLottos(expenses);
        outputView.printPurchasedLottos(purchasedLottos);
    }

    private void inputWinningNumbers(){
        List<Integer> rawValuse = inputView.inputWinningNumbers();
        Integer bonusNumber = inputView.inputBonusNumber();
        createdWinningNumbers = winningNumbers.generateFromRawValues(rawValuse, bonusNumber);
    }

    private void showWinningResult(){
        showWinningStatus();
        showReturnRatio();
    }

    private void showWinningStatus(){
        winningStatusResult = winningResultCalculator.generateWinningStatus(purchasedLottos,createdWinningNumbers);
        outputView.printWinningStatus(winningStatusResult);
    }

    private void showReturnRatio(){
        returnRatioResult = winningResultCalculator.generateReturnRatio(expenses,winningStatusResult);
        outputView.printReturnRatio(returnRatioResult);
    }
    
}

