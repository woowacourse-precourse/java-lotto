package lotto;

import lotto.controller.LottoController;
import lotto.domain.Answer;
import lotto.domain.User;
import lotto.view.LottoView;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController(
                new Answer(),
                new User(),
                new LottoView());

        try {
            lottoController.purchase();
            lottoController.inputAnswer();
            lottoController.getResult();
        } catch (IllegalArgumentException i) {
            System.out.println(i.getMessage());
        }
    }
}
