package lotto;

import lotto.model.PurchasePrice;
import lotto.view.InputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            InputView inputView = new InputView();
            PurchasePrice purchasePrice = new PurchasePrice(inputView.inputPurchasePrice());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
