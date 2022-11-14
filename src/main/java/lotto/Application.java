package lotto;

import lotto.controller.LottoGameController;
import lotto.service.LottoGameService;

public class Application {

    public static void main(String[] args) {
        LottoGameController lottoGameController = new LottoGameController(new LottoGameService());
        try {
            lottoGameController.run();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
