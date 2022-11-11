package lotto;

import lotto.view.InputView;

public class Application {

    private static InputView inputView;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        inputView = new InputView();
        inputView.buyLotto();
    }
}
