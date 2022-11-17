package lotto;

import lotto.controller.LottoController;
import lotto.domain.service.LottoService;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoController controller = new LottoController(new LottoService());
        controller.run();
    }
}
