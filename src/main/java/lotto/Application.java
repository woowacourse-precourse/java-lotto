package lotto;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Purchase purchase = new Purchase();
        Print print = new Print();
        WinningNumber winningNumber = new WinningNumber();

        System.out.println("구입금액을 입력해 주세요.");
        List<Lotto> purchasedLotto = purchase.lottoPurchase();
        print.printPurchasedLotto(purchasedLotto);

        System.out.println("\n당첨 번호를 입력해 주세요.");
        winningNumber.getWinningNumber();
        WinningResult winningResult = new WinningResult(winningNumber);
        winningResult.winningHistory(purchasedLotto);
        print.printWinningHistory(winningResult.winningHistory(purchasedLotto));
        print.printWinningRate(winningResult.winningRate(purchase.purchaseAmount));
    }
}
