package controller;

import lotto.LottoMachine;
import lotto.LottoStore;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MainController {
    private int lottoCount;
    public List<List<Integer>> totalLotteries;

    public void run() {
        moneyController();
        makeLottoController();
    }

    public void moneyController() {
        int inputMoney = InputView.inputMoney();
        lottoCount = new LottoStore().calculateLottoCount(inputMoney);
        OutputView.printLottoCount(lottoCount);
    }

    public void makeLottoController() {
        totalLotteries = new LottoMachine().createLotto(lottoCount);
        new LottoMachine().sortLottoNumbers(totalLotteries);
        OutputView.printLotteries(totalLotteries);
    }
}
