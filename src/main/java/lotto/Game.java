package lotto;

import java.util.*;

public class Game {

    public void play(int lottoCount) {
        System.out.println("\n" + lottoCount + "개를 구매했습니다.");
        List<Lotto> purchasedLottos = Lotto.generateLottoSet(lottoCount);
        printPurchasedLottos(purchasedLottos);
        WinningNumber winningNumber = new WinningNumber();
        winningNumber.generator();

        Calculator calculator = new Calculator();
        for (Lotto purchasedLotto : purchasedLottos) {
            calculator.calculate(purchasedLotto.getLottoNumber(), winningNumber.getWinningLotto(), winningNumber.getBonusNumber());
            System.out.println(calculator.getSameCmt());
            System.out.println(calculator.getBonusCorrect());
        }
    }

    public void printPurchasedLottos(List<Lotto> purchasedLottos) {
        for (Lotto purchasedLotto : purchasedLottos) {
            System.out.println(purchasedLotto.getLottoNumber());
        }
    }
}
