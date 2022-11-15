package lotto;

import lotto.Controller.LottoController;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController();

        try {
            lottoController.startLottoGame();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
