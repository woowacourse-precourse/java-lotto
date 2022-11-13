package controller;

import lotto.LottoMachine;
import lotto.LottoStore;
import lotto.WinningLotto;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MainController {
    private int lottoCount;
    public List<List<Integer>> totalLotteries;

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
        new WinningLotto().creteWinningNumbers(winningNumber, bonusNumber);
    }
}
