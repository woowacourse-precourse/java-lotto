package lotto;

import OutputView.Print;

import java.util.List;

public class Game {

    public void play(int lottoCount) {
        Print.numberOfLottoPurchasedMsg(lottoCount);
        List<Lotto> purchasedLottos = Lotto.generateLottoSet(lottoCount);
        Print.purchasedLottosMsg(purchasedLottos);
        WinningNumber winningNumber = new WinningNumber();
        winningNumber.generator();
        Earning earning = new Earning();
        WinningHistory winningHistory = new WinningHistory();
        Calculator calculator = new Calculator();
        double earningAmount = 0;
        for (Lotto purchasedLotto : purchasedLottos) {
            calculator.calculate(purchasedLotto.getLottoNumber(), winningNumber.getWinningLotto(), winningNumber.getBonusNumber());
            earningAmount += earning.calculate(calculator.getSameCmt(), calculator.getBonusCorrect());
            earning.RankCalculate(calculator.getSameCmt(), calculator.getBonusCorrect(), winningHistory);
        }
        winningHistory.print();
        Print.earningRateMsg(earning.rateCalculate(lottoCount * 1000, earningAmount));
    }
}
