package lotto;

import lotto.controller.LottoStoreController;

public class Application {
    public static void main(String[] args) {
        LottoStoreController store = new LottoStoreController();
        store.run();
    }
}
