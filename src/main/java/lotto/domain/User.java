package lotto.domain;

import java.util.List;
import lotto.domain.lotto.PurchaseLottos;
import lotto.domain.lotto.WinningLotto;
import lotto.domain.statistics.WinningStatistics;
import lotto.io.InputControl;
import lotto.io.OutputControl;

public class User {

    public PurchaseAmount inputPurchaseAmount() {
        displayMessage("구입금액을 입력해 주세요.");
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

    public void displayMessage(String msg) {
        OutputControl.println(msg);

    }

    public void displayErrorMessage(Exception exception) {
        OutputControl.println(exception.getMessage());
    }

    private int inputLottoBonusNum() {
        return InputControl.readInt();
    }

    private List<Integer> inputLottoNums() {
        displayMessage("당첨 번호를 입력해 주세요.");
        return InputControl.readInts(",");
    }

    public void displayPurchaseResult(PurchaseLottos purchaseLottos) {
        displayMessage("보너스 번호를 입력해 주세요.");
        OutputControl.println(purchaseLottos.toString());
    }
}
