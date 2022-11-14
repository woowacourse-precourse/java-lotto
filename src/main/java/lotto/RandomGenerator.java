package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.Random;

public class RandomGenerator {
    public  static List<Integer> generateRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
