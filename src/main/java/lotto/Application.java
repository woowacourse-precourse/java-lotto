package lotto;

import lotto.controller.LottoStore;

public class Application {
    public static void main(String[] args) {
        LottoStore lottoStore = new LottoStore();
        lottoStore.startLottoService();
    }
}
