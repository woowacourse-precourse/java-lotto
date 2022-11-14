package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Generator {
    public static List<Lotto> generateLotto(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for(int i = 1; i <= count; i++) {
            lottos.add(new Lotto(generateRandomNumbers()));
        }
        return lottos;
    }

    public static List<Integer> generateRandomNumbers() {
        List<Integer> list = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        List<Integer> sortedList = new ArrayList<>();
        sortedList.addAll(list);
        Collections.sort(sortedList);

        return sortedList;
    }

}
