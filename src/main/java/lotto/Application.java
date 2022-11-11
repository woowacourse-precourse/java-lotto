package lotto;

import lotto.console.Input;
import lotto.console.Output;

public class Application {

    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame(new Input(), new Output());
        lottoGame.play();
    }
}
