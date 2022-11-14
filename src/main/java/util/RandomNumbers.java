package util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNumbers {
    public static final int START_INCLUSIVE = 1;
    public static final int END_INCLUSIVE = 45;

    public static List<Integer> pickRandomUniqueNumbers(int num) {
        List<Integer> pickUniqueNumbersInRange = new ArrayList<>(Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE, num));
        Collections.sort(pickUniqueNumbersInRange);
        return pickUniqueNumbersInRange;
    }
}
