package lotto;

import java.util.*;

public class Game {

    public void play(int lottoCount) {
        System.out.println("\n" + lottoCount + "개를 구매했습니다.");
        List<Lotto> purchasedLottos = Lotto.generateLottoSet(lottoCount);
        printPurchasedLottos(purchasedLottos);
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
        System.out.println("총 수익률은 " + earning.rateCalculate(lottoCount*1000, earningAmount) + "%입니다.");
    }

    public void printPurchasedLottos(List<Lotto> purchasedLottos) {
        for (Lotto purchasedLotto : purchasedLottos) {
            System.out.println(purchasedLotto.getLottoNumber());
        }
    }
}
