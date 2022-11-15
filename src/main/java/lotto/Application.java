package lotto;

import control.LottoGame;
import view.InputView;
import view.OutputView;

public class Application {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    public static void main(String[] args) {

        new LottoGame(inputView,outputView).playLotto();
    }
}
