package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

import static lotto.util.InputChecker.*;

public class NumberGenerator {


    private NumberGenerator() {
    }

    public static List<Integer> randomNumbers() {
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, LIMITED_LENGTH));
        numbers.sort(Integer::compareTo);
        return numbers;
    }
}
