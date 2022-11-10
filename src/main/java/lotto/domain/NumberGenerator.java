package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberGenerator {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int CREATE_NUMBER = 6;


    public List<Integer> createRandomLottoNumber() {
        List<Integer> number = Randoms.pickUniqueNumbersInRange(
                MIN_NUMBER, MAX_NUMBER, CREATE_NUMBER);
        return number;
    }

    public List<List<Integer>> createNumbersBasedPrice(int count) {
        List<List<Integer>> numbers = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            numbers.add(createRandomLottoNumber());
        }
        return numbers;
    }

    public List<List<Integer>> sortLottoNumbers(List<List<Integer>> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            Collections.sort(numbers.get(i));
        }
        return numbers;
    }

    public void showPurchaseLottery(int count) {
        List<List<Integer>> numbers = createNumbersBasedPrice(count);
        numbers = sortLottoNumbers(numbers);
        for (int i = 0; i < count; i++) {
            System.out.println(numbers.get(i));
        }
    }
}
