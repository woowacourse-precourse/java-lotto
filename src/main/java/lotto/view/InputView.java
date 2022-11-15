package lotto.view;

import lotto.core.LotteryPublisher;
import lotto.core.User;
import java.util.List;

public class InputView {
    private final User user;

    public InputView(User user) {
        this.user = user;
    }

    public int inputPurchaseAmount() {
        printInputPurchaseAmountMessage();
        int purchaseAmount = user.inputPurchaseAmount();
        printPublishCountMessage(purchaseAmount);
        return purchaseAmount;
    }

    public List<Integer> inputWinningNumber() {
        printInputWinningNumberMessage();
        return user.inputWinningNumber();
    }

    public int inputBonusNumber(List<Integer> winningNumber) {
        printInputBonusNumberMessage();
        return user.inputBonusNumber(winningNumber);
    }

    private void printInputPurchaseAmountMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    private void printPublishCountMessage(int purchaseAmount) {
        System.out.println();
        System.out.println(purchaseAmount / LotteryPublisher.LOTTO_PRICE + "개를 구매했습니다.");
    }

    private void printInputWinningNumberMessage() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    private void printInputBonusNumberMessage() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
    }
}
