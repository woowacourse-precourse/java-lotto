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

        Calculator calculator = new Calculator();
        for (Lotto purchasedLotto : purchasedLottos) {
            calculator.calculate(purchasedLotto.getLottoNumber(), winningNumber.getWinningLotto(), winningNumber.getBonusNumber());
            System.out.println(earning.calculate(calculator.getSameCmt(), calculator.getBonusCorrect()));
        }
    }

    public void printPurchasedLottos(List<Lotto> purchasedLottos) {
        for (Lotto purchasedLotto : purchasedLottos) {
            System.out.println(purchasedLotto.getLottoNumber());
        }
    }

}
