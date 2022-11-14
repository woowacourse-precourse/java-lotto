package lotto.controller;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private LottoService lottoService;
    private MoneyService moneyService;
    private WinningNumbersService winningNumbersService;
    private WinningMoneyService winningMoneyService;

    public void start() {
        purchaseLottos(insertMoney());
        pickWinningNumbers();
        profit();
    }

    private int insertMoney() {
        moneyService = new MoneyService(InputView.inputMoney());

        return moneyService.getLottoCount();
    }

    private void purchaseLottos(int lottoCount) {
        OutputView.outputAnnounceMoney(lottoCount);
        lottoService = new LottoService(lottoCount);
        OutputView.outputLottoList(lottoService.getLottoList());
    }

    private void pickWinningNumbers() {
        winningNumbersService = new WinningNumbersService(InputView.inputWinningNumbers(),
                InputView.inputWinningBonus());
    }

    private void profit() {
        OutputView.outputWinningScript();
        WinningNumbers winningNumbers = winningNumbersService.getWinningNumbers();

        winningMoneyService = new WinningMoneyService(winningNumbers, lottoService.getLottoList());
        winningMoneyService.doAllRank();


        OutputView.outputWinningOrder(winningMoneyService.getRanking());
        OutputView.outputProfitRate(winningMoneyService.calculateProfitRate(moneyService.getMoney(),
                winningMoneyService.calculateWinningMoney()));
    }
}
