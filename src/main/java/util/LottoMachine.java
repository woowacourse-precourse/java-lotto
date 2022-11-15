package util;

import camp.nextstep.edu.missionutils.Randoms;
import domain.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
        List<Integer> prelist = new ArrayList<>();
        prelist.addAll(Randoms.pickUniqueNumbersInRange(1, 45, 6).subList(0, 6));
        prelist.sort(Comparator.naturalOrder());
        return prelist;
    }
}
