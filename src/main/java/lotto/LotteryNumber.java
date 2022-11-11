package lotto;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;


public class LotteryNumber {
    private List<List<Integer>> numbers = new ArrayList<>();

    public LotteryNumber(int money) {
        int iterationNumber = money / 1000;
        generateNumbers(iterationNumber);
    }

    private void generateNumbers(int iterationNumber) {
        for (int i = 0; i < iterationNumber; i++) {
            List<Integer> randomNumbers = pickUniqueNumbersInRange(1, 45, 6);
            numbers.add(randomNumbers);
        }
    }

    public List<List<Integer>> getNumbers() {
        return this.numbers;
    }
}
