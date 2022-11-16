package lotto;

import java.util.List;

import lotto.service.Service;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {
    Service service = new Service();

    public void run() {
        if (!purchaseLotto()) {
            return;
        }

        printPurchaseResult();

        if(!setWinningNumber()) {
            return;
        }

        if(!setBonusNumber()) {
            return;
        }

        printResult();
        printProfitRate();
    }

    private boolean purchaseLotto() {
        String lottoPrice = InputView.getLottoPrice();
        return service.generateLottoList(lottoPrice);
    }

    private void printPurchaseResult() {
        List<List<Integer>> purchaseResult = service.getPurchaseResult();
        OutputView.printPurchaseResult(purchaseResult);
    }

    private boolean setWinningNumber() {
        String winningNumberInput = InputView.getWinningNumberInput();
        return service.setWinningNumber(winningNumberInput);
    }

    private boolean setBonusNumber() {
        String bonusNumber = InputView.getBonusNumberInput();
        return service.setBonusNumber(bonusNumber);
    }

    private void printResult() {
        List<String> results = service.getWinningResult();
        OutputView.printWinningResult(results);
    }

    private void printProfitRate() {
        String profitRate = service.getProfitRate();
        OutputView.printProfitRate(profitRate);
    }
}
