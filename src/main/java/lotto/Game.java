package lotto;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public void playGame() {
        Print.inputMoney();
        int numberOfLottos = Input.inputPurchaseMoney();
        Print.outputNumberOfLotto(numberOfLottos);
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < numberOfLottos; i++) {
            List<Integer> lotto = Lotto.issueLotto();
            lottos.add(new Lotto(lotto));
        }

    }
}
