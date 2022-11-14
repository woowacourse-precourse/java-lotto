package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        findDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void findDuplicate(List<Integer> numbers) {
        Set<Integer> numberPool = new HashSet<>();
        for (Integer number : numbers) {
            if (!numberPool.add(number)) {
                throw new IllegalArgumentException("[ERROR] 로또에 중복되는 수가 있습니다");
            }
        }
    }

    // TODO: 추가 기능 구현
    public int compareWithAnswer(WinNumber winNumber) {
        int correctCount = 0;
        for (int target : winNumber.getWinNumber()) {
            if (numbers.contains(target)) {
                correctCount++;
            }
        }
        return makeResult(correctCount,numbers.contains(winNumber.getBonusNumber()));
    }

    private int makeResult(int correctCount, boolean correctBonus) {
        if (correctCount == 3) {
            return 5;
        }
        if (correctCount == 4) {
            return 4;
        }
        if (correctCount == 5) {
            if (correctBonus) {
                return 2;
            }
            return 3;
        }
        if(correctCount == 6){
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
