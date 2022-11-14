package lotto;

import java.util.*;

public class Controller {

    public void run(int lottoCount) {

        System.out.println("\n" + lottoCount + "개를 구매했습니다.");
        List<Lotto> purchasedLotto = Lotto.generateLottoSet(lottoCount);
        Game game = new Game();
        game.generator();
    }
}
