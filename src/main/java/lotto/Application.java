package lotto;

import lotto.controller.LottoService;

public class Application {
    public static void main(String[] args) {
        LottoService lottoService = new LottoService();
        lottoService.start();
    }
}
