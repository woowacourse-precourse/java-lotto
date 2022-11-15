package lotto;

import lotto.controller.LottoController;
import lotto.view.Input;

public class Application {

    public static void main(String[] args) {
        try {
            LottoController lottoController = new LottoController();
            lottoController.execute();
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
        }
    }
}