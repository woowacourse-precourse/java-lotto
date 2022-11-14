package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;

public class NumberGenerator {

    public static List<Integer> createDifferentRandomNumbers() {
        return sortNumbers(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }

    public static List<Integer> sortNumbers(List<Integer> numbers) {
        return numbers.stream().sorted().collect(Collectors.toList());
    }

    public static int createRandomNumber() {
        return Randoms.pickNumberInRange(1, 45);
    }
}
