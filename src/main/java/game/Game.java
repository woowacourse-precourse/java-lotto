package game;

import outputView.Output;
import winning.WinningNumber;
import lotto.Lotto;

import java.util.List;

public class Game {

    private final int purchaseAmount;

    public Game(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public void play() {
        int lottoCount = purchaseAmount/1000;
        Output.numberOfLottoPurchasedMsg(lottoCount);
        List<Lotto> purchasedLottos = Lotto.generateLottoSet(lottoCount);
        Output.purchasedLottosMsg(purchasedLottos);
        WinningNumber winningNumber = new WinningNumber();
        winningNumber.generator();
        GameOver gameOver = new GameOver();
        gameOver.finish(purchaseAmount, purchasedLottos, winningNumber);
    }
}
