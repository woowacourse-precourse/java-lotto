package lotto;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;

public class Creation {
    public static List<Integer> lotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return sortLotto(numbers);
    }

    private static List<Integer> sortLotto(List<Integer> numbers) {
        return numbers.stream().sorted().collect(Collectors.toList());
    }
}
