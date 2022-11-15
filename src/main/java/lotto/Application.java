package lotto;

import lotto.domain.Cashier;

public class Application {
    public static void main(String[] args) {
        try {
            Cashier cashier = new Cashier();
            cashier.sellLottos();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
