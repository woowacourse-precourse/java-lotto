package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
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
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(minNumber, maxNumber, count);
        sortRandomNumbers(randomNumbers);
        return randomNumbers;
    }

    private void sortRandomNumbers(List<Integer> randomNumbers) {
        Collections.sort(randomNumbers);
    }
}
