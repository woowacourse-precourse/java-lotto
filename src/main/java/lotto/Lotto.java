package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public static List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(Constant.MIN_NUMBER, Constant.MAX_NUMBER, Constant.SIZE);
    }

    public Lotto(List<Integer> numbers) {
        List<Integer> sorted = new ArrayList<>(numbers);

        Validator.lottoNumber(numbers);
        Collections.sort(sorted);
        System.out.println(sorted);
        this.numbers = sorted;
    }
}
