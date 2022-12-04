package lotto;

import LottoController.LottoController;
import domain.LottoGame;
import domain.Result;
import view.InputView;
import view.OutputView;

public class Application {
    public static final String COMMA = ",";

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoGame lottoGame = new LottoGame(new Result());
        LottoController lottoController = new LottoController(new InputView(), new OutputView(), lottoGame);

        try{
            lottoController.start();
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }



    }

}
