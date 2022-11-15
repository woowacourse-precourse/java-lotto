package lotto;

import java.util.Comparator;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
        validate(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }

        boolean hasDuplicatedNum = checkDuplicate(numbers);
        if (hasDuplicatedNum) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int matchNumber(int pickedNumber) {
        int matchCount = 0;

        for (int j = 0; j < this.numbers.size(); j++) {

            if (this.numbers.get(j) == pickedNumber) {
                matchCount++;
            }
            if (this.numbers.get(j) > pickedNumber) {
                return matchCount;
            }
        }
        return matchCount;
    }

    public boolean checkDuplicate(List<Integer> numbers) {
        for (int i = 0; i < 5; i++) {
            int selectedNum = numbers.get(i);

            int result = matchNumber(selectedNum);
            if (result > 1){
                return true;
            }
        }

        return false;
    }
}
