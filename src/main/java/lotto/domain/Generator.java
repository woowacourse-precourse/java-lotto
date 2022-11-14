package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Generator {
    public List<List<Integer>> lottery = new ArrayList<List<Integer>>();
    public List<Integer> createRandomLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }
    public List<List<Integer>> createLottoByPay(int pay) {
        for (int i=0; i<pay; i++) {
            lottery.add(createRandomLotto());
        }
        return lottery;
    }
}
