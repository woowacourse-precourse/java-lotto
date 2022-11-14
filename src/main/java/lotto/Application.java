package lotto;

import lotto.controller.LottoController;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController();
        try {
            lottoController.startGame();
        }catch (IllegalArgumentException exception){
            System.out.print(exception.getMessage());
        }
    }
}
