package lotto;

import lotto.model.LottoService;

public class Application {
    public static void main(String[] args) {
        LottoService lottoService = new LottoService();
        lottoService.playLotto();
    }
}
