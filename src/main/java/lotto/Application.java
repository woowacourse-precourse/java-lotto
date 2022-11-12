package lotto;


import lotto.Controller.InputController;
import lotto.Model.Buyer;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Buyer buyer = new Buyer();
        InputController.inputPurchaseAmount(buyer);
    }
}
