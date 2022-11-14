package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NumberGenerator {

    List<List<Integer>> numbers;

    public List<Integer> createRandomLottoNumber() {
        List<Integer> number = Randoms.pickUniqueNumbersInRange(
                Constant.MIN_NUMBER, Constant.MAX_NUMBER, Constant.CREATE_NUMBER);
        return number;
    }

    public List<List<Integer>> createNumbersBasedPrice(int count) {
        numbers = new ArrayList<>();

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
        for (int i = 0; i < count; i++) {
            System.out.println(numbers.get(i));
        }
    }

    public void testRandomNumberGenerator() {
        numbers = Arrays.asList(
                Arrays.asList(21, 8, 23, 41, 42, 43),
                Arrays.asList(3, 5, 11, 16, 32, 38),
                Arrays.asList(7, 11, 16, 35, 36, 44),
                Arrays.asList(1, 8, 11, 31, 41, 42),
                Arrays.asList(13, 14, 16, 38, 42, 45),
                Arrays.asList(7, 11, 30, 40, 42, 43),
                Arrays.asList(2, 13, 22, 32, 38, 45),
                Arrays.asList(1, 3, 5, 14, 22, 45)
                );
    }
}
