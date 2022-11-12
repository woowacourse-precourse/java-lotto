package lotto;

import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        outputView.printLotteries();
    }
}
