package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (isLength(numbers)) {
            throw new IllegalArgumentException();
        }

        for (int i=0; i<numbers.size(); i++) {
            if (!isInRange(numbers.get(i))) {
                throw new IllegalArgumentException();
            }
            if (isDuplicate(numbers, numbers.get(i), i)) {
                throw new IllegalArgumentException();
            }
        }
    }

    private static boolean isLength(List<Integer> numbers) {
        return numbers.size() == 5;
    }

    private static boolean isInRange(Integer number) {
        return number > 0 && number < 46;
    }

    private static boolean isDuplicate(List<Integer> numbers, Integer num, int index) {
        for (int j=0; j<index; j++) {
            if(numbers.get(j).equals(num)) {
                return false;
            }
        }
        return true;
    }

}
