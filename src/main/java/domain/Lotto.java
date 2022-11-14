package domain;

import view.ValidMessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        checkValidate(numbers);
        this.numbers = new ArrayList<>(numbers);
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    private boolean validateLength(List<Integer> numbers) {
        boolean isValid = false;
        if (numbers.size() != 6) {
            isValid = true;
        }
        return isValid;
    }

    private boolean validateRepeat(List<Integer> numbers) {
        boolean isValid = false;
        for (int i = 0; i < numbers.size(); i++) {
            if (Collections.frequency(numbers, numbers.get(i)) > 1) {
                isValid = true;
                break;
            }
        }
        return isValid;
    }

    private boolean validateOver(List<Integer> numbers) {
        boolean isValid = false;
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) < 1 && numbers.get(i) > 45) {
                isValid = true;
                break;
            }
        }
        return isValid;
    }

    private void checkValidate(List<Integer> numbers) {
        if (validateLength(numbers) || validateRepeat(numbers) || validateOver(numbers)) {
            throw new IllegalArgumentException(ValidMessage.ValidGenerateLotto.getPrintMessage());
        }
    }
}
