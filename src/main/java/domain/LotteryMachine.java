package domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LotteryMachine {
    private final List <List <Integer>> lottos = new ArrayList <>();

    public LotteryMachine(int lottoCount) {
        for (int i = 0; i < lottoCount; i++) {
            createLotto();
        }
    }

    private void createLotto() {
        List <Integer> newLotto = new ArrayList <>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Lotto lotto = new Lotto(newLotto);
        lottos.add(lotto.getNumbers());
    }
}
