package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNumberGenerator {
    public static List<Integer> makeRandomNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return sortList(numbers);
    }

    private static ArrayList<Integer> sortList(List<Integer> numbers) {
        ArrayList<Integer> randomNumberList = new ArrayList<>(numbers);
        Collections.sort(randomNumberList);
        return randomNumberList;
    }
}
