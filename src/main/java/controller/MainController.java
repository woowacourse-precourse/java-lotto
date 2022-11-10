package controller;

import model.Purchase;
import view.PrintView;
import view.ReceiveView;

public class MainController {

    public Purchase purchaseLotto() {
        PrintView.purchaseLotto();

        int purchaseLotto = 0;
        try {
            purchaseLotto = ReceiveView.purchaseLotto();
        } catch (Exception e) {
            PrintView.error(e.getMessage());
            throw new IllegalArgumentException(e.getMessage());
        }

        Purchase purchase = new Purchase(purchaseLotto);
        return purchase;
    }
}
