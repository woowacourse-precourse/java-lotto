package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    public static final int WIN_NUMBER_SIZE = 6;

    private final List<Integer> numbers;
    private Prize grade = Prize.UNCHECKED;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ExceptionHandler.WRONG_NUMBERS_COUNT);
        }
        Set<Integer> nums = new HashSet<>(numbers);
        if (numbers.size() != nums.size()) {
            throw new IllegalArgumentException(ExceptionHandler.DUPLICATED_LOTTO_NUMBERS);
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

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Prize getGrade() {
        return grade;
    }

    // TODO: 추가 기능 구현
}
