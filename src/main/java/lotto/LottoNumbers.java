package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoNumbers {

    private List<Integer> basket;
    private List<List<Integer>> numbers;

    public LottoNumbers(int want) {
        want = want / 1000;
        this.numbers = createRandomNumbers(want);
    }

    public List<List<Integer>> getNumbers() {
        return numbers;
    }

    private List<List<Integer>> createRandomNumbers(int want) {
        numbers = new ArrayList<>();
        for (int i = 0; i < want; i++) {
            basket = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(basket);
            numbers.add(basket);
        }
        return numbers;
    }
}
