package lotto;

import lotto.controller.Game;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {

    private static final InputView INPUT_VIEW = new InputView();
    private static final OutputView OUTPUT_VIEW = new OutputView();

    public static void main(String[] args) {
        new Game(INPUT_VIEW, OUTPUT_VIEW).play();
    }
}
