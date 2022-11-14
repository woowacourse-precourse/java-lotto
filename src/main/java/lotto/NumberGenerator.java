package lotto;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {
    public List<Integer> generateSixRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public int generateRandomNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 1).get(0);
    }
}
