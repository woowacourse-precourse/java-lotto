package lotto;

import java.util.List;

import lotto.service.Service;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {
    Service service = new Service();

    public void run() {
        purchaseLotto();
        printPurchaseResult();
        setWinningNumber();
        setBonusNumber();
    }

    private void purchaseLotto() {
        String lottoPrice = InputView.getLottoPrice();
        service.generateLottoList(lottoPrice);
    }

    private void printPurchaseResult() {
        List<List<Integer>> purchaseResult = service.getPurchaseResult();
        OutputView.printPurchaseResult(purchaseResult);
    }

    //TODO: method 이름 바꾸기
    private void setWinningNumber() {
        String winningNumber = InputView.getWinningNumber();
        service.setWinningNumber(winningNumber);
    }

    private void setBonusNumber() {
        String bonusNumber = InputView.getBonusNumberInput();
        service.setBonusNumber(bonusNumber);
    }
}
