package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomGenerator {

    public List<Integer> getRandomNumber() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }

}
