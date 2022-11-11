package lotto;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Purchase purchase = new Purchase();
        Print print = new Print();
        WinningNumber winningNumber = new WinningNumber();

        List<Lotto> purchasedLotto = purchase.lottoPurchase();
        print.printPurchasedLotto(purchasedLotto);

        winningNumber.getWinningNumber();
        WinningResult winningResult = new WinningResult(winningNumber);
        winningResult.winningHistory(purchasedLotto);
//        print.printWinningHistory(winningResult.winningHistory(purchasedLotto));
        winningResult.winningRate(purchase.purchaseAmount);
    }
}
