package lotto;

import lotto.domain.LottoStore;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoStore lottoStore = new LottoStore();

        try {
            lottoStore.buyLotto();
            lottoStore.determiningWinningNumber();
            lottoStore.judgeLottoNumber();
            lottoStore.statsLotto();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

    }
}
