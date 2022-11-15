package lotto.domain;

import static lotto.message.PrintMessage.INPUT_BONUS_NUMBER;
import static lotto.message.PrintMessage.INPUT_PURCHASE_AMOUNT;
import static lotto.message.PrintMessage.INPUT_WINNING_LOTTO;

import java.util.List;
import lotto.domain.lotto.PurchaseLottos;
import lotto.domain.lotto.WinningLotto;
import lotto.domain.statistics.WinningStatistics;
import lotto.io.InputControl;
import lotto.io.OutputControl;
import lotto.message.PrintMessage;

public class User {

    public PurchaseAmount inputPurchaseAmount() {
        displayMessage(INPUT_PURCHASE_AMOUNT);
        return new PurchaseAmount(InputControl.readInt());
    }

    public WinningLotto inputLotto() {
        List<Integer> inputLottoNums = inputLottoNums();
        int lottoBonusNum = inputLottoBonusNum();

        return new WinningLotto(inputLottoNums, lottoBonusNum);
    }

    public void displayGameResult(WinningStatistics winningStatistics) {
        OutputControl.println(winningStatistics.toString());
    }

    public void displayMessage(PrintMessage printMessage) {
        OutputControl.println(printMessage.toString());

    }

    public void displayErrorMessage(Exception exception) {
        OutputControl.println(exception.getMessage());
    }

    private int inputLottoBonusNum() {
        return InputControl.readInt();
    }

    private List<Integer> inputLottoNums() {
        displayMessage(INPUT_WINNING_LOTTO);
        return InputControl.readInts(",");
    }

    public void displayPurchaseResult(PurchaseLottos purchaseLottos) {
        displayMessage(INPUT_BONUS_NUMBER);
        OutputControl.println(purchaseLottos.toString());
    }
}
