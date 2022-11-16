package lotto;

import lotto.Console.InputMessages;
import lotto.Console.OutputMessages;
import lotto.Controller.LottoGameController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoGameController lottoGameController = new LottoGameController();
        lottoGameController.LottoSystem(new InputMessages(), new OutputMessages());
    }
}
