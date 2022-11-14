package lotto.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {
    public List<Integer> createRandomUniqueNumbers() {
        List<Integer> temp = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        List<Integer> numbers = new ArrayList<>(temp);
        numbers.sort(Comparator.naturalOrder());
        return numbers;
    }
}
