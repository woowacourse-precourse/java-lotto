package lotto;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Purchase purchase = new Purchase();
        WinningNumber winningNumber = new WinningNumber();
        List<List<Integer>> purchasedLotto = purchase.lottoPurchase();
        winningNumber.getWinningNumber();
        WinningResult winningResult = new WinningResult(winningNumber);
        winningResult.winningHistory(purchasedLotto);
    }
}
