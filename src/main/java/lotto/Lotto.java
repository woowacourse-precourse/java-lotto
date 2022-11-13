package lotto;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        ArrayList<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        this.numbers = sortedNumbers;
    }

    public Lotto(String input) {
        List<Integer> numbers = stringToList(input);
        validate(numbers);
        ArrayList<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        this.numbers = sortedNumbers;
    }

    private List<Integer> stringToList(String input) {
        List<Integer> result = new ArrayList<>();
        String[] inputToArray = input.split(",");
        for (String str : inputToArray) {
            result.add(Integer.parseInt(str));
        }
        return result;
    }

    private void validate(List<Integer> numbers) {
        validateNull(numbers);
        validateDuplicate(numbers);
        validateLength(numbers);
        validateOutRange(numbers);
    }

    private void validateNull(List<Integer> numbers) {
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateOutRange(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) < 1 || numbers.get(i) > 45) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numberSet.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public String toNumberForm() {
        String message = "[";
        for (int number : numbers) {
            message += number + ", ";
        }
        message = message.substring(0, message.length() - 2) + "]";
        return message;
    }

    public boolean hasBonus(int bonus) {
        return numbers.contains(bonus);
    }

    public int compareLotto(Lotto userLotto) {
        int correctCount = 0;
        for (int i = 0; i < 6; i++) {
            if (userLotto.hasBonus(numbers.get(i)) == true)
                correctCount++;
        }
        return correctCount;
    }
}
