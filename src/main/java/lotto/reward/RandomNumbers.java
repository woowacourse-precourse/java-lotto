package lotto.reward;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNumbers {
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final int START_INDEX = 0;
    private static final int COUNT = 6;

    public List<Integer> getRandomNumbers() {
        return shuffleNumbers(setRandomNumbers());
    }

    private List<Integer> shuffleNumbers(List<Integer> randomNumbers) {
        Collections.shuffle(randomNumbers);
        return randomNumbers.subList(START_INDEX, COUNT);
    }

    private List<Integer> setRandomNumbers() {
        List<Integer> setRandomNum = new ArrayList<>();
        for (int i = START_NUMBER; i < END_NUMBER; i++) {
            setRandomNum.add(i);
        }
        return setRandomNum;
    }
}
