package lotto.controller;

import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    LottoService lottoService = new LottoService();

    public void startLotto() {
        try {
            int money = Integer.parseInt(InputView.inputMoney());

            lottoService.buyLotto(money);
            initWinningLotto();
            initBonusNumber();
            lottoProgress();

        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 금액은 숫자만 입력 가능합니다.");
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
        lottoResult();
    }

    public void lottoResult() {
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
