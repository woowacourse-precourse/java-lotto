package lotto;

import lotto.domain.LottoStore;

public class Application {
    public static void main(String[] args) {
        try {
            LottoStore lottoStore = new LottoStore();
            lottoStore.sellLotto();
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
        }

    }
}