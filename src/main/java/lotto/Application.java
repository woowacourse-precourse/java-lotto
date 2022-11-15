package lotto;

import lotto.controller.StoreController;

public class Application {
    public static void main(String[] args) {
        StoreController storeController = new StoreController();

        storeController.run();
    }
}
