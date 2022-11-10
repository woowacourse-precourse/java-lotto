package lotto;

import lotto.domain.LottoStore;

public class Application {
    public static void main(String[] args) {
        LottoStore lottoStore = new LottoStore();
        lottoStore.sellLotto();
    }
}