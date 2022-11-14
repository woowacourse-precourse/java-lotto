package controller;

import lotto.LottoBank;
import lotto.LottoMachine;
import lotto.LottoStore;
import lotto.WinningLotto;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MainController {
    private int lottoCount;
    private List<List<Integer>> totalLotteries;
    private List<Integer> winningNumbers;
    private int[] rankCount;

    public void run() {
        moneyController();
    }

    public void moneyController() {
        int inputMoney = InputView.inputMoney();
        lottoCount = new LottoStore().calculateLottoCount(inputMoney);
        OutputView.printLottoCount(lottoCount);
        makeLottoController();
    }

    public void makeLottoController() {
        totalLotteries = new LottoMachine().createLotto(lottoCount);
        new LottoMachine().sortLottoNumbers(totalLotteries);
        OutputView.printLotteries(totalLotteries);
        makeWinningLottoController();
    }

    public void makeWinningLottoController() {
        String winningNumber = InputView.inputWinningNumber();
        int bonusNumber = InputView.inputBonusNumber();
        winningNumbers = new WinningLotto().creteWinningNumbers(winningNumber, bonusNumber);
        compareController();
    }

    public void compareController() {
        rankCount = new LottoBank().LottoNumberCompareResult(totalLotteries, winningNumbers);
        compareResult();
    }

    public void compareResult() {
        OutputView.printResult(rankCount);
    }
}
