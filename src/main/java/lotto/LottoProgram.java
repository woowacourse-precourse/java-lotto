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
        userInterface.printWinningHistory(winningResult.winningHistory(purchasedLotto));
        userInterface.printWinningRate(winningResult.winningRate(purchase.purchaseAmount));
    }

    private List<Lotto> purchaseLotto() {
        userInterface.printEnterAmount();
        List<Lotto> purchasedLotto = purchase.lottoPurchase();
        userInterface.printPurchasedLotto(purchasedLotto);

        return purchasedLotto;
    }

    private void enterWinningNumber() {
        winningNumber.getWinningNumber();
    }
}
