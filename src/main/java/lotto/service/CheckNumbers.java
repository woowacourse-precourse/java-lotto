package lotto.service;

import java.util.List;

public class CheckNumbers {
    private int count = 0;

    public void setCount(int count) {
        this.count = count;
    }

    public int getCorrect(List<Integer> winningNumbers, List<Integer> myNumbers, int bonusNumber) {
        for (int idx = 0; idx < winningNumbers.size(); idx++) {
            if (winningNumbers.contains(myNumbers.get(idx))) {
                count++;
            }
        }
        if (count == 6) {
            count++;
        }
        if (count == 5) {
            secondGrade(myNumbers, bonusNumber);
        }

        return count;
    }

    public void secondGrade(List<Integer> myNumbers, int bonusNumber) {
        if (myNumbers.contains(bonusNumber)) {
            count++;
        }
    }
}
