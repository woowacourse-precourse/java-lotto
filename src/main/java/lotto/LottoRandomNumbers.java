package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoRandomNumbers {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    public static final int LOTTO_NUMBER_COUNT = 6;

    private List<Integer> basket;
    private List<List<Integer>> numbers;

    public LottoRandomNumbers(String want) {
        int count = Integer.parseInt(want);
        count = count / 1000;
        this.numbers = createRandomNumbers(count);
    }

    public List<List<Integer>> getNumbers() {
        return numbers;
    }

    private List<List<Integer>> createRandomNumbers(int count) {
        numbers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            basket = new ArrayList<>(Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_NUMBER_COUNT));
            Collections.sort(basket);
            numbers.add(basket);
        }
        return numbers;
    }
}
