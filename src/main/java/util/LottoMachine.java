package util;

import camp.nextstep.edu.missionutils.Randoms;
import domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    public static List<Lotto> getLotto(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0 ; i < count ; i++) {
            lottos.add(new Lotto(getRandomLotto()));
        }
        return lottos;
    }

    private static List<Integer> getRandomLotto() {
        List<Integer> prelist = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return prelist.subList(0, 6);
    }
}
