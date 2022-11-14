package lotto;

import lotto.domain.Cashier;

public class Application {
    public static void main(String[] args) {
        Cashier cashier = new Cashier();
        cashier.buyLottos();
        cashier.setWinningRule();
        cashier.saveResultInAccount();
        cashier.getResultInAccount();
        cashier.getYieldInAccount();
    }
}
