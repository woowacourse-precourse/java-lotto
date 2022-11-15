package game;

import view.Input;
import view.Output;
import utills.Earning;
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

        WinningNumber winningNumber = Input.inputWinningNumber();
        finish(purchaseAmount, purchasedLottos, winningNumber);
    }

    public void finish(int purchasedAmount, List<Lotto> purchasedLottos, WinningNumber winningNumber) {
        Earning earning = new Earning();
        for (Lotto purchasedLotto : purchasedLottos) {
            earning.scoreCalculate(purchasedLotto, winningNumber);
        }
        Output.printResult(purchasedAmount, earning);
    }
}
