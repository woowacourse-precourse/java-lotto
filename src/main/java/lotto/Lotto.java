package lotto;

import lotto.domain.Message;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        // 6개가 아닌 경우 Exception
        sizeCheck(numbers);
        //중복 숫자가 있는 경우 Exception
        duplicateCheck(numbers);
        //1~45이외에 숫자가 있는 경우 Exception
        for (int num : numbers) {
            rangeCheck(num);
        }
    }

    private void sizeCheck(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Message.Exception_NotCorrectSize.getMessage());
        }
    }

    private void duplicateCheck(List<Integer> numbers) {
        Set<Integer> numSet = new HashSet<>(numbers);
        if (numSet.size() != numbers.size()) {
            throw new IllegalArgumentException(Message.Exception_DuplicateNum.getMessage());
        }
    }

    public static void rangeCheck(int num) {
        if (num < 1 || num > 45)
            throw new IllegalArgumentException(Message.Exception_NotInRange.getMessage());
    }

    public void bonus_duplicateCheck(int num) {
        if (numbers.contains(num)) {
            throw new IllegalArgumentException(Message.Exception_DuplicateNum.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
