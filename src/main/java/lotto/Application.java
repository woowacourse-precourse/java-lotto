package lotto;

import lotto.controller.GameController;
import lotto.domain.LottoIssuer;
import lotto.domain.ResultGenerator;
import lotto.view.OutputConsole;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoIssuer lottoIssuer = new LottoIssuer();
        ResultGenerator resultGenerator = new ResultGenerator();
        try{
            GameController gameController = new GameController(lottoIssuer, resultGenerator);
            gameController.play();
        } catch (IllegalArgumentException e) {
            OutputConsole.printErrorMessage(e.getMessage());
        }
    }
}
