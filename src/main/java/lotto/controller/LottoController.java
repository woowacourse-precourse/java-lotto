package lotto.controller;

import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    LottoService lottoService = new LottoService();

    public void startLotto() {
        int money = Integer.parseInt(InputView.inputMoney());
        try {
            lottoService.buyLotto(money);
            initWinningLotto();
            initBonusNumber();
            lottoProgress();

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void initWinningLotto() {
        String winningNumber = InputView.inputWinningNumber();

        try {
            lottoService.saveWinningLotto(winningNumber);
            showUserLottoInfo();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void showUserLottoInfo() {
        OutputView.printPurchasedLotto(lottoService.getUserLotties().size());
        OutputView.printLottoNumbers(lottoService.getUserLotties());
    }

    public void initBonusNumber() {
        String bonusNumber = InputView.inputBonusNumber();

        try {
            lottoService.saveBonusNumber(bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void lottoProgress() {
        lottoService.initResultLotto();
        lottoService.saveResultLotto();
        showUserLottiesResult();

        lottoService.calculateReward();
        showProfitResult();
    }

    public void showUserLottiesResult() {
        OutputView.printLottoStatistics(lottoService.getLottiesResult());
    }

    public void showProfitResult() {
        OutputView.printLottoProfit(lottoService.getProfitRate());
    }
}
