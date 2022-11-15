package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Utils.validateNumbersSize(numbers);
        Utils.validateUniqueNumbers(numbers);
        Utils.validateNumbersRange(numbers);
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    private List<String> convertStringList() {
        List<String> strNumbers = new ArrayList<>();

        for (int num : numbers) {
            strNumbers.add(String.valueOf(num));
        }
        return strNumbers;
    }

    public String toString() {
        List<String> strNumbers = convertStringList();
        return "[" + String.join(",", strNumbers) + "]";
    }
    // TODO: 추가 기능 구현

    private int compareNum(int num) {
        if (numbers.contains(num)) {
            return 1;
        }
        return 0;
    }

    public int compareNumbers(Lotto lotto) {
        int result = 0;
        for (int num : lotto.numbers) {
            result += compareNum(num);
        }
        return result;
    }
}
