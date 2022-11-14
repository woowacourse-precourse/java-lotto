package lotto;

import java.util.List;

public class LottoProgram {
    private Purchase purchase;
    private UserInterface userInterface;
    private WinningNumber winningNumber;
    private WinningResult winningResult;

    LottoProgram() {
        this.purchase = new Purchase();
        this.userInterface = new UserInterface();
        this.winningNumber = new WinningNumber();
    }

    void play() {
        List<Lotto> purchasedLotto = purchaseLotto();
        enterWinningNumber();

        winningResult = new WinningResult(winningNumber);
        winningResult.winningHistory(purchasedLotto);

        printLottoResult(purchasedLotto);
    }

    private List<Lotto> purchaseLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        List<Lotto> purchasedLotto = purchase.lottoPurchase();
        userInterface.printPurchasedLotto(purchasedLotto);

        return purchasedLotto;
    }

    private void enterWinningNumber() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        winningNumber.getWinningNumber();
    }

    private void printLottoResult(List<Lotto> purchasedLotto) {
        userInterface.printWinningHistory(winningResult.winningHistory(purchasedLotto));
        userInterface.printWinningRate(winningResult.winningRate(purchase.purchaseAmount));
    }
}
