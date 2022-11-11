package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoNumbers {

    private List<Integer> basket;
    private List<List<Integer>> numbers;

    public LottoNumbers(String want) {
        if (want.length() != 4) {
            System.out.println("[ERROR]");
            throw new IllegalArgumentException("[ERROR]");
        }
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
            basket = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(basket);
            numbers.add(basket);
        }
        return numbers;
    }
}
