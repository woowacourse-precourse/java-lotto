package lotto;

import java.util.List;

import lotto.service.Service;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {
    Service service = new Service();

    public void run() {
        boolean purchaseSuccess = purchaseLotto();
        if (purchaseSuccess) {
            printPurchaseResult();
            setWinningNumber();
            setBonusNumber();
            printResult();
            printProfitRate();
        }
    }

    private boolean purchaseLotto() {
        String lottoPrice = InputView.getLottoPrice();
        return service.generateLottoList(lottoPrice);
    }

    private void printPurchaseResult() {
        List<List<Integer>> purchaseResult = service.getPurchaseResult();
        OutputView.printPurchaseResult(purchaseResult);
    }

    private void setWinningNumber() {
        String winningNumberInput = InputView.getWinningNumberInput();
        service.setWinningNumber(winningNumberInput);
    }

    private void setBonusNumber() {
        String bonusNumber = InputView.getBonusNumberInput();
        service.setBonusNumber(bonusNumber);
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
