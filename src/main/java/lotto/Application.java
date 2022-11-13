package lotto;

import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException{
        LottoGame lottoGame=new LottoGame();
        lottoGame.startGame();
    }
}
