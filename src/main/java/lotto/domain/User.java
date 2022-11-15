package lotto.domain;

import static lotto.message.LottoLine.LOTTO_NUMBER_DELIMITER;
import static lotto.message.PrintMessage.INPUT_BONUS_NUMBER;
import static lotto.message.PrintMessage.INPUT_PURCHASE_AMOUNT;
import static lotto.message.PrintMessage.INPUT_WINNING_LOTTO;

import java.util.List;
import lotto.domain.lotto.WinningLotto;
import lotto.domain.statistics.WinningStatistics;
import lotto.io.InputControl;
import lotto.io.OutputControl;
import lotto.message.PrintMessage;
import lotto.view.PurchaseMessage;

public class User {

    public PurchaseAmount inputPurchaseAmount() {
        displayMessage(INPUT_PURCHASE_AMOUNT);
        return new PurchaseAmount(InputControl.readInt());
    }

    public WinningLotto inputWinningLotto() {
        List<Integer> inputLottoNums = inputLottoNums();
        int lottoBonusNum = inputLottoBonusNum();

        return new WinningLotto(inputLottoNums, lottoBonusNum);
    }

    public void displayGameResult(WinningStatistics winningStatistics) {
        OutputControl.println(winningStatistics.getMessage());
    }

    public void displayMessage(PrintMessage printMessage) {
        OutputControl.println(printMessage.getMessage());
    }

    public void displayLineSeparator() {
        OutputControl.println(System.lineSeparator());
    }

    public void displayErrorMessage(Exception exception) {
        OutputControl.println(exception.getMessage());
    }

    private int inputLottoBonusNum() {
        displayMessage(INPUT_BONUS_NUMBER);
        int ret = InputControl.readInt();
        displayLineSeparator();

        return ret;
    }

    private List<Integer> inputLottoNums() {
        displayMessage(INPUT_WINNING_LOTTO);
        List<Integer> ret = InputControl.readInts(LOTTO_NUMBER_DELIMITER.getValue());
        displayLineSeparator();

        return ret;
    }

    public void displayPurchaseResult(PurchaseMessage purchaseMessage) {
        OutputControl.println(purchaseMessage.getMessage());
    }
}
