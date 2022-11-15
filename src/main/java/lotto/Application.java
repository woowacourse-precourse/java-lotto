package lotto;

import lotto.controller.LottoStore;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            LottoStore lottoStore = new LottoStore();
            lottoStore.buyLotto();
            lottoStore.inputWinningNumbers();
            lottoStore.inputBonusNumber();
            lottoStore.outputResult();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
