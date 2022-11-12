package lotto;

import lotto.controller.Controller;
import lotto.view.View;

public class Application {

    private static final Controller controller = new Controller();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        View purchaseAmountInputView = controller.createPurchaseAmountInputView();
        purchaseAmountInputView.print();
    }
}
