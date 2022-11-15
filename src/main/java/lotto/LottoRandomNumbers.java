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
        int piece = Integer.parseInt(want);
        piece = piece / 1000;
        this.numbers = createRandomNumbers(piece);
    }

    public List<List<Integer>> getNumbers() {
        return numbers;
    }

    private List<List<Integer>> createRandomNumbers(int want) {
        numbers = new ArrayList<>();
        for (int i = 0; i < want; i++) {
            basket = new ArrayList<>(Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_NUMBER_COUNT));
            Collections.sort(basket);
            numbers.add(basket);
        }
        return numbers;
    }
}
