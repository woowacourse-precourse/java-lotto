package controller;

import lotto.*;
import view.InputView;
import view.OutputView;

import java.util.Collections;
import java.util.List;

public class MainController {
    private int inputMoney;
    private int lottoCount;
    private int bonusNumber;
    private String winningNumber;
    private List<List<Integer>> totalLotteries;
    private List<Integer> winningNumbers;
    int[] winningNumberMatchCount;

    public void run() {
        moneyController();
    }

    public void moneyController() {
        try {
            inputMoney = InputView.inputMoney();
        } catch (IllegalArgumentException e) {
            e.getMessage();
            System.out.println("[ERROR]: 숫자 외 다른 문자를 입력하셨습니다.");
            new LottoException().inputException(inputMoney);
        }
        lottoCount = new LottoStore().calculateLottoCount(inputMoney);
        OutputView.printLottoCount(lottoCount);
        makeLottoController();
    }

    public void makeLottoController() {
        totalLotteries = new LottoMachine().createLotto(lottoCount);
        OutputView.printLotteries(totalLotteries);
        makeWinningLottoController();
    }

    public void makeWinningLottoController() {
        winningNumber = InputView.inputWinningNumber();
        new LottoException().WinningException(winningNumber);
        winningNumbers = new WinningLotto().creteWinningNumbers(winningNumber);
        compareController();
    }

    public void compareController() {
        new LottoBank().calculateWinningMatchNumber(lottoCount, totalLotteries, winningNumbers);
        bonusNumber = InputView.inputBonusNumber();
        winningNumberMatchCount = new LottoBank().compareBonusNumber(lottoCount, bonusNumber,
                totalLotteries, winningNumbers);
        OutputView.printResult(winningNumberMatchCount);
        OutputView.printWinningMessage();
        profitRateController();
    }

    public void profitRateController() {
        double profitRate = new LottoBank().calculateTotalMoney(winningNumberMatchCount, inputMoney);
        OutputView.printProfitRate(profitRate);
    }
}
