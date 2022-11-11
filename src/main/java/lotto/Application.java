package lotto;

import lotto.controller.LottoGame;
import lotto.domain.Customer;
import lotto.view.LottoGameView;
import lotto.view.ViewValidator;

public class Application {
    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame(new LottoGameView(new ViewValidator()), new Customer());
        lottoGame.play();
    }
}
