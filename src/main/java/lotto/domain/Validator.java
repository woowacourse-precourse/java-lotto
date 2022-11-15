package lotto.domain;

import lotto.enums.ErrorMessage;
import lotto.enums.Range;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    public List<Integer> inputNumber(String inputNum) {
        String[] inputN = inputNum.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String s : inputN) {
            int n = stringToInt(s);
            if (validateNumRange(n)) {
                numbers.add(n);
            }
        }
        checkDuplicated(numbers);
        return numbers;
    }

    public int stringToInt(String s) {
        validateNumber(s);
        return Integer.parseInt(s);
    }

    public void validateNumber(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                throw new IllegalArgumentException(ErrorMessage.NUM_ERROR.getErrorMessage());
            }
        }
    }

    public boolean validateNumRange(int idxNum) {
        if (idxNum > Range.MAX_RANGE.get() || idxNum < Range.MIN_RANGE.get()) {
            throw new IllegalArgumentException(ErrorMessage.RANGE_ERROR.getErrorMessage());
        }
        return true;
    }

    public void validateLength(List<Integer> input) {
        if (input.size() != Range.DIGIT.get()) {
            throw new IllegalArgumentException(ErrorMessage.LEN_ERROR.getErrorMessage());
        }
    }

    public void checkDuplicated(List<Integer> numbers) {
        Set<Integer> inputSet = new HashSet<>(numbers);
        if (inputSet.size() != Range.DIGIT.get()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_ERROR.getErrorMessage());
        }
    }

    public void checkNumAll(List<Integer> numbers) {
        validateLength(numbers);
        checkDuplicated(numbers);
        for (int n : numbers) {
            validateNumRange(n);
        }
    }


}
