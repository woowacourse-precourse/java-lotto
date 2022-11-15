package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Generator {
    public List<List<Integer>> lotteries = new ArrayList<List<Integer>>();
    public List<Integer> createRandomLotto() {
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(numbers);
        return numbers;
    }
    public List<List<Integer>> createLottoByPay(int pay) {
        for (int i=0; i<pay; i++) {
            lotteries.add(createRandomLotto());
        }
        return lotteries;
    }

}
