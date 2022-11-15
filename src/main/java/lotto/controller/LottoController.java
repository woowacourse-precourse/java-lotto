package lotto.controller;

import lotto.exception.ExceptionMessage;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    LottoService lottoService = new LottoService();

    public void startLotto() {
        try {
            lottoService.buyLotto(InputView.inputMoney());
            showUserLottoInfo();
            initWinningLotto();
            initBonusNumber();
            lottoProgress();

        } catch (NumberFormatException e) {
            OutputView.printErrorMessage(ExceptionMessage.INPUT_NOT_NUMBER_ERROR.getMessage());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
        }
    }

    public void initWinningLotto() {
        String winningNumber = InputView.inputWinningNumber();
        lottoService.saveWinningLotto(winningNumber);
    }

    public void showUserLottoInfo() {
        OutputView.printPurchasedLotto(lottoService.getUserLotties().size());
        OutputView.printLottoNumbers(lottoService.getUserLotties());
    }

    public void initBonusNumber() {
        String bonusNumber = InputView.inputBonusNumber();
        lottoService.saveBonusNumber(bonusNumber);
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
