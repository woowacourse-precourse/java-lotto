package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Randoms {

    public static List<Integer> createUniqueNumbersInRange(int startInclusive, int endInclusive, int count) {
        Set<Integer> numbersSet = new HashSet<>();

        while (numbersSet.size() < count) {
            int number = pickNumberInRange(startInclusive, endInclusive);
            numbersSet.add(number);
        }

        return new ArrayList<>(numbersSet);
    }
}
