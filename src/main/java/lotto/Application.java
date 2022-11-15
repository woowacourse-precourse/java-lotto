package lotto;

import lotto.controller.LottoGameController;
public class Application {
    public static void main(String[] args) {
        LottoGameController lottoController = new LottoGameController();
        try {
            lottoController.startGame();
            lottoController.calculateWinning();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
