package lotto;

import java.util.*;

public class Controller {

    public void run(int lottoCount) {

        System.out.println("\n" + lottoCount + "개를 구매했습니다.");
        List<Lotto> purchasedLottos = Lotto.generateLottoSet(lottoCount);
        printPurchasedLottos(purchasedLottos);
        Game game = new Game();
        game.generator();

    }

    public void printPurchasedLottos(List<Lotto> purchasedLottos) {
        for (Lotto purchasedLotto : purchasedLottos) {
            System.out.println(purchasedLotto.getLottoNumber());
        }
    }
}
