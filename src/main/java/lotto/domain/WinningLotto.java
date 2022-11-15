package lotto.domain;

import lotto.Lotto;
import lotto.Utils.Error;

import java.util.*;
import java.util.stream.Collectors;

public class WinningLotto {
    private final List<Integer> numbers;
    private final int bonusNumber;

    public WinningLotto(String numbersInput, String bonusNumberInput) {
        List<Integer>numbers = convertInputToNumbers(numbersInput);
        this.numbers = new Lotto(numbers).getNumbers();

        int bonusNumber = convertInputToNumber(bonusNumberInput);
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;

    }
    private void validate(int bonusNumber) {
        Error error = new Error();
        if (bonusNumber == 0) {
            error.outOfRange();
        }
        if (bonusNumber < 1 || bonusNumber > 45) {
            error.outOfRange();
        }
        if (this.numbers.contains(bonusNumber)) {
            error.duplicated();
        }
    }
    private List<Integer> convertInputToNumbers(String input) {
        Error error = new Error();
        List<Integer> result = new ArrayList<>();
        try {
            result = Arrays.stream(input.split(","))
                    .map(s->Integer.valueOf(s))
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            error.outOfRange();
        }
        return result;
    }

    private int convertInputToNumber(String input) {
        int number = 0;
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return 0;
        }
        return number;
    }
    public List<Integer> getNumbers() {
        return this.numbers;
    }
    public int getBonusNumber() {
        return this.bonusNumber;
    }
}

