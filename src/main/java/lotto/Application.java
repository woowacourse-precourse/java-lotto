package lotto;

import view.LottoGameView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoGameController machine = new LottoGameController(LottoGameView.getInstance());
        machine.run();
    }
}
