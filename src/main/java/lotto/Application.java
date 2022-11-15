package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoStore;
import lotto.view.LottoPrinter;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = LottoController.create(new LottoStore(), new LottoPrinter());
        try {
            lottoController.start();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
