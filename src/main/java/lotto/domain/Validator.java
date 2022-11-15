package lotto.domain;

import lotto.enums.ErrorMessage;
import lotto.enums.Range;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    public List<Integer> inputNumber(String inputNum) {
        String[] inputN = winNumCommaValidate(inputNum);
        List<Integer> numbers = new ArrayList<>();

        for (String s : inputN) {
            int n = stringToInt(s);
            if (validateNumRange(n)) {
                numbers.add(n);
            }
        }
        validateLength(numbers);
        checkDuplicated(numbers);
        return numbers;
    }

    private String[] winNumCommaValidate(String inputNum) {
        String[] inputN = new String[6];
        boolean check = true;
        for (int i = 0; i < Range.DIGIT.get(); i++) {
            commaValidate(inputNum.charAt(i));
        }
        inputN = inputNum.split(",");
        return inputN;
    }

    private boolean commaValidate(char c) {
        if (!Character.isDigit(c) && c != ',') {
            throw new IllegalArgumentException(ErrorMessage.COMMA_ERROR.getErrorMessage());
        }
        return true;
    }

    public int stringToInt(String s) {
        validateNumber(s);
        return Integer.parseInt(s);
    }

    private boolean validateNumber(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                throw new IllegalArgumentException(ErrorMessage.NUM_ERROR.getErrorMessage());
            }
        }
        return true;
    }

    private boolean validateNumRange(int idxNum) {
        if (idxNum > Range.MAX_RANGE.get() || idxNum < Range.MIN_RANGE.get()) {
            throw new IllegalArgumentException(ErrorMessage.RANGE_ERROR.getErrorMessage());
        }
        return true;
    }

    private void validateLength(List<Integer> input) {
        if (input.size() != Range.DIGIT.get()) {
            throw new IllegalArgumentException(ErrorMessage.LEN_ERROR.getErrorMessage());
        }
    }

    private void checkDuplicated(List<Integer> numbers) {
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

    private void bonusDuplicate(int bonus, List<Integer> numbers) {
        if (numbers.contains(bonus)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_DUPLICATE_ERROR.getErrorMessage());
        }
    }

    public int bonusTotal(String stringBonus, List<Integer> numbers) {
        int bonus = stringToInt(stringBonus);
        bonusDuplicate(bonus, numbers);
        validateNumRange(bonus);
        return bonus;
    }


}
