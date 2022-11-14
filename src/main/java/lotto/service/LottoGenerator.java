package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.entity.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {

    public static List<Lotto> generateMyLotto(int purchaseCount) {
        List<Lotto> myLotto = new ArrayList<>();

        for (int i = 0; i < purchaseCount; i++) {
            List<Integer> numbers = generateNumbers();
            Lotto lotto = new Lotto(numbers);
            myLotto.add(lotto);
        }
        return myLotto;
    }

    private static List<Integer> generateNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        numbers = new ArrayList<>(numbers);
        Collections.sort(numbers);
        return numbers;
    }
}
