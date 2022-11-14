package lotto;

import lotto.controller.Controller;
import lotto.domain.Buyer;
import lotto.domain.Rank;
import lotto.service.LottoService;
import lotto.view.View;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Controller controller = new Controller(new LottoService(), new Buyer(), new View(), new Rank());
        controller.startGame();
    }
}
