package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Operation {
    static final int MATCH3 = 3;
    static final int MATCH4 = 4;
    static final int MATCH5 = 5;
    static final int MATCH6 = 6;
    static final int MATCH5_BONUS = 0;

    static List<Lotto> buyLotto(int amount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < (amount / 1000); i++) {
            Lotto lotto = new Lotto(generateNumbers());
            lottos.add(lotto);
        }
        return lottos;
    }

    static List<Integer> generateNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 6) {
            int random = Randoms.pickNumberInRange(1, 45);
            if (!numbers.contains(random)) {
                numbers.add(random);
            }
        }
        return numbers;
    }

}
