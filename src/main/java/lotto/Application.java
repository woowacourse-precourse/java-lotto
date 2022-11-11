package lotto;

import lotto.service.LottoService;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoService lottoService = new LottoService();
        lottoService.play();
    }
}
