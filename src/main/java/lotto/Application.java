package lotto;

import lotto.controller.LottoGameController;

public class Application {

    public static void main(String[] args) {
        LottoGameController lottoGameController = new LottoGameController();

        try {
            lottoGameController.run();
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
        }
    }
}
