package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {
    public void playGame() {
        Print.inputMoney();
        int numberOfLottos = Input.inputPurchaseMoney();
        Print.outputNumberOfLotto(numberOfLottos);
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < numberOfLottos; i++) {
            List<Integer> lotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(lotto));
        }
    }
}
