package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

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
