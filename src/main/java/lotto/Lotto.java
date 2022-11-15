package lotto;

import java.util.ArrayList;
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
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        if (hasDuplicate(numbers) || isInvalidRange(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    private boolean isInvalidRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            String num = number.toString();
            if (!num.matches("[1-9]|1[0-9]|2[0-9]|3[0-9]|4[0-5]")) {
                return true;
            }
        }
        return false;
    }

    private boolean hasDuplicate(List<Integer> numbers) {
        List<Integer> input1 = new ArrayList<>(numbers);
        Set<Integer> input2 = new HashSet<>(numbers);

        if (input1.size() != input2.size()) {
            return true;
        }
        return false;
    }

    public void printNumbers() {
        printFormat(this.numbers);
        return;
    }

    private void printFormat(List<Integer> numbers) {
        System.out.print("[");
        for (int i = 0; i < numbers.size(); i++) {
            int number = numbers.get(i);
            if (i == numbers.size() - 1) {
                System.out.print(number);
                continue;
            }
            System.out.print(number + ", ");
        }
        System.out.println("]");
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

}
