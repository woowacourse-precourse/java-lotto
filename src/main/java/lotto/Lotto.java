package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private Prize grade = Prize.UNCHECKED;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public void checkResult(List<Integer> winNumbers, Integer bonusNumber) {
        int correctCount = compareWithWinNumbers(winNumbers);
        int bonusCount = compareWithBonusNumber(bonusNumber);
        checkGrade(correctCount, bonusCount);
    }

    public int compareWithWinNumbers(List<Integer> winNumbers) {
        int result = 0;
        for (Integer winNumber : winNumbers) {
            if (numbers.contains(winNumber)) {
                result++;
            }
        }
        return result;
    }

    public int compareWithBonusNumber(Integer bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            return 1;
        }
        return 0;
    }

    public void checkGrade(int correctCount, int bonusCount) {
        if (correctCount == 6) {
            grade = Prize.FIRST;
        } else if (correctCount == 5){
            checkBonusGrade(bonusCount);
        } else if (correctCount == 4) {
            grade = Prize.FOURTH;
        } else if (correctCount == 3) {
            grade = Prize.FIFTH;
        } else if (correctCount <= 2) {
            grade = Prize.NONE;
        }
    }

    public void checkBonusGrade(int bonusCount) {
        if (bonusCount == 1) {
            grade = Prize.SECOND;
        } else if (bonusCount == 0) {
            grade = Prize.THIRD;
        }
    }

    // TODO: 추가 기능 구현
}
