package lotto;

import java.util.*;

public class Controller {

    public void run(int lottoCount) {

        System.out.println("\n" + lottoCount + "개를 구매했습니다.");
        List<Lotto> purchasedLottos = Lotto.generateLottoSet(lottoCount);
        printPurchasedLottos(purchasedLottos);
        WinningNumber winningNumber = new WinningNumber();
        winningNumber.generator();
        System.out.println("////////////~~~~///////");
        System.out.println(winningNumber.getBonusNumber());
        System.out.println(winningNumber.getWinningLotto());
    }

    public void printPurchasedLottos(List<Lotto> purchasedLottos) {
        for (Lotto purchasedLotto : purchasedLottos) {
            System.out.println(purchasedLotto.getLottoNumber());
        }
    }
}
