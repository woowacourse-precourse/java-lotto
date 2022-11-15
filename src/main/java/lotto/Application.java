package lotto;

import lotto.controller.LottoController;
import lotto.model.service.LottoService;
import lotto.view.OutputView;

public class Application {

    public static void main(String[] args) {
        LottoService lottoService = new LottoService();
        LottoController lottoController = new LottoController(lottoService);

        try {
            lottoController.buyLotto();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
        }
    }
}
