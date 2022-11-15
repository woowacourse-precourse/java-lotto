package game;

import outputView.Output;
import winning.WinningNumber;
import lotto.Lotto;

import java.util.List;

public class Game {

    public void play(int lottoCount) {
        Output.numberOfLottoPurchasedMsg(lottoCount);
        List<Lotto> purchasedLottos = Lotto.generateLottoSet(lottoCount);
        Output.purchasedLottosMsg(purchasedLottos);
        WinningNumber winningNumber = new WinningNumber();
        winningNumber.generator();
        GameOver gameOver = new GameOver();
        gameOver.finish(lottoCount * 1000, purchasedLottos, winningNumber);
    }
}
