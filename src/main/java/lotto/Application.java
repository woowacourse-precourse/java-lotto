package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoService;

public class Application {
    public static void main(String[] args) {
        try {
            LottoController lottoController = new LottoController(lottoService());
            lottoController.run();
        } catch (RuntimeException exception) {
            System.out.print(exception.getMessage());
        }
    }

    private static LottoService lottoService() {
        return new LottoService();
    }
}
