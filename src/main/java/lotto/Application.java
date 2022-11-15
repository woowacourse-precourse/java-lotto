package lotto;

import lotto.controller.LottoController;
import lotto.model.LottoFactory;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    private static final String ERROR_MESSAGE = "[ERROR] ";


    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoFactory lottoFactory = new LottoFactory();

        LottoController lottoController = new LottoController(inputView, outputView, lottoFactory);
        lottoController.lottery();
    }






    public static void printErrorMessage(String s){
        System.out.println(ERROR_MESSAGE+s);
    }

}
