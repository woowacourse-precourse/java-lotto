package lotto;

import lotto.domain.LottoController;
import lotto.domain.LottoGenerator;
import lotto.domain.WinningNumbersGenerator;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController
                = new LottoController(new LottoGenerator(), new WinningNumbersGenerator());
        try {
            lottoController.run();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
