package lotto;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;


public class LotteryNumber {
    private ArrayList<ArrayList<Integer>> numbers = new ArrayList<>();

    public LotteryNumber(int money) {
        int iterationNumber = money / 1000;
        generateNumbers(iterationNumber);
    }

    private void generateNumbers(int iterationNumber) {
        for (int i = 0; i < iterationNumber; i++) {
            List<Integer> randomNumbers = pickUniqueNumbersInRange(1, 45, 6);
            numbers.add(sortElementNumbers(randomNumbers));
        }
    }

    private ArrayList<Integer> sortElementNumbers(List<Integer> numbers) {
        ArrayList<Integer> answer = new ArrayList();

        for(int n : numbers){
            answer.add(n);
        }

        Collections.sort(answer);
        return answer;
    }
    public ArrayList<ArrayList<Integer>> getNumbers() {
        return this.numbers;
    }
}
