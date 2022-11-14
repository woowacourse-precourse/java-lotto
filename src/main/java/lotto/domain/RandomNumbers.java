package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RandomNumbers {
    private final List<Integer> randomNumbers;

    public RandomNumbers(int minNumber, int maxNumber, int count) {
        this.randomNumbers = generateRandomNumbers(minNumber, maxNumber, count);
    }

    public List<Integer> getRandomNumbers() {
        return randomNumbers;
    }

    private List<Integer> generateRandomNumbers(int minNumber, int maxNumber, int count) {
        return Randoms.pickUniqueNumbersInRange(minNumber, maxNumber, count);
    }
}
