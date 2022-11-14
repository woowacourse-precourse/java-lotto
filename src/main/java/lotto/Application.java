package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class Application {

    public static Player player = new Player();
    public static LottoIssuer lottoIssuer = new LottoIssuer();
    public static DrawingMachine drawingMachine = new DrawingMachine();
    //    public static Calculator calculator = new Calculator();
    public static Integer numberOfLottoToBuy = 0;

    public static void main(String[] args) {
        // Input: Get Amount
        getAmount();

        // Buy lotto
        buyLotto();

        // Print All the Lotto
        printAllTheLotto();

        // Input: Winning Number & Bonus Number
        getWinningNumber();

        // Print Statics
        printStatics();
    }

    public static void getAmount() {
        OutputView.printAmountInputMessage();
        numberOfLottoToBuy = InputView.getAmount() / 1000;
    }

    public static void buyLotto() {
        OutputView.printPurchaseAmountMessage(numberOfLottoToBuy);
        for (int i = 0; i < numberOfLottoToBuy; i++) {
            player.buyLotto(lottoIssuer.issueLotto());
        }
    }

    public static void printAllTheLotto() {
        for (Lotto lotto : player.getLottoInHand()) {
            OutputView.printLottoNumber(lotto);
        }
    }

    public static void getWinningNumber() {
        OutputView.printWinningNumberInputMessage();
        drawingMachine.setWinningNumber();

        OutputView.printBonusNumberInputMessage();
        drawingMachine.setBonusNumber();
    }

    public static void printStatics() {
        List<Integer> result = LottoResult.getResult(player.getLottoInHand(), drawingMachine.getWinningNumber(), drawingMachine.getBonusNumber());
        OutputView.printStatic(result, Calculator.getEarningRate(result));
    }
}
