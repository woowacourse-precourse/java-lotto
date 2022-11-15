package lotto.domain;


import lotto.View.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

public class TargetNumbers {
    private static final int SIZE = 6;

    private TargetNumbers(List<String> input) {
        List<Integer> numbers = new ArrayList<>();
        isInputFormValid(input, numbers);
        new Lotto(numbers); // Lotto 클래스의 number 로 전달
    }

    public static TargetNumbers getInstance(String input) {
        List<String> output = List.of(input.split(","));
        return new TargetNumbers(output);
    }

    private void isInputFormValid(List<String> input, List<Integer> output) throws IllegalArgumentException {
        for (String s : input) {
            boolean notDigit = s.chars().anyMatch(Character::isDigit);
            if (!notDigit) {
                throw new IllegalArgumentException(ErrorMessage.INPUT_NUMBER.getValue());
            }
            output.add(Integer.parseInt(s));
        }

    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != SIZE) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_SIX_NUMBER.getValue());
        }
    }

    public void isInstanceOf(Class<IllegalArgumentException> illegalArgumentExceptionClass) {

    }
}
