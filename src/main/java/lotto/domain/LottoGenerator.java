package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.util.NumericProperties.MAX_NUM;
import static lotto.util.NumericProperties.MIN_NUM;
import static lotto.util.NumericProperties.SIZE;

public class LottoGenerator {

    static List<List<Integer>> myLotto;

    public static List<List<Integer>> generateLotto() {
        myLotto = new ArrayList<>();
        for (int i = 0; i < PurchaseAmount.getNumberOfLotto(); i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_NUM.get(), MAX_NUM.get(), SIZE.get());
            List<Integer> copiedNumbers = new ArrayList<>(numbers);
            Collections.sort(copiedNumbers);
            myLotto.add(copiedNumbers);
        }
        return myLotto;
    }
}
