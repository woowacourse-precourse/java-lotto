package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.List;

public class LottoPrinter {

    public static List<Integer> makeUniqueNumbers() {
        while (true) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            HashSet<Integer> uniqueNumbers = new HashSet<>(numbers);

            if (numbers.size() == uniqueNumbers.size()) return numbers;
        }
    }
}
