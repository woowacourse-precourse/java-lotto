package lotto;

import lotto.service.LottoService;

public class Application {
    public static void main(String[] args) {
        new LottoService().startLotto();
    }
}
