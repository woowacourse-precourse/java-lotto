package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class Lottery {
    static ArrayList<Lotto> lottery = new ArrayList<>();

    public Lottery(int purchaseNumber) {
        for (int index = 0; index < purchaseNumber; index++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lottery.add(lotto);
        }
    }

    public ArrayList<Lotto> getLottery() {
        return lottery;
    }
}
