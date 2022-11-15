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
    public Prize compareWithAnswer(WinNumber winNumber) {
        int correctCount = 0;
        for (int target : winNumber.getWinNumber()) {
            if (numbers.contains(target)) {
                correctCount++;
            }
        }
        return Prize.makingResult(correctCount, numbers.contains(winNumber.getBonusNumber()));
    }


    @Override
    public String toString() {
        return numbers.toString();
    }
}
