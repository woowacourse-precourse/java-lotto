package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoService;

public class Application {
    public static void main(String[] args) {
        try {
            LottoService lottoService = new LottoService();
            LottoController lottoController = new LottoController(lottoService);
            lottoController.run();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
