package lotto;

import lotto.controller.LottoController;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            final LottoController lottoController = new LottoController();
            lottoController.start();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
