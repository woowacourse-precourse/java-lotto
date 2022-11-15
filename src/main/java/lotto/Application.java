package lotto;

import lotto.domain.LottoGame;
import lotto.domain.strategy.RandomCreateStrategy;
import lotto.view.InputView;

public class Application {
    public static void main(String[] args) {
        GameFrame gameFrame = new GameFrame();
        gameFrame.start(new LottoGame(), new RandomCreateStrategy());
    }
}
