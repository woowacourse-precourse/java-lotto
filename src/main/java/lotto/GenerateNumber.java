package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class GenerateNumber {
    public static List<Integer> generateSixRandomNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }
}
