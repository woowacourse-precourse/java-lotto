package lotto.service;

import java.util.List;

public class CheckNumbers {
    private int count = 0;

    public void setCount(int count) {
        this.count = count;
    }

    /**
     * 1등: 6개 번호 일치 / 2,000,000,000원
     * 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
     * 3등: 5개 번호 일치 / 1,500,000원
     * 4등: 4개 번호 일치 / 50,000원
     * 5등: 3개 번호 일치 / 5,000원
     * 메소드 15줄 이내로
     */

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
