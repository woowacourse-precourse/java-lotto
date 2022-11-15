package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoCreator {

    public static List<Integer> createNumbers() {
        List<Integer> numbers;

        numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers);
        return numbers;
    }

    public static List<List<Integer>> createLottos(int amount) {
        List<List<Integer>> lottos = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            lottos.add(createNumbers());
        }
        return lottos;
    }
}
