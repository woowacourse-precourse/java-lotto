package lotto.domain;

import lotto.constants.LottoConstants;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumber {
    private final List<Integer> numbers;

    public WinningNumber(String userInput) {
        List<Integer> numbers = validate(userInput);
        this.numbers = numbers;
    }

    private List<Integer> validate(String userInput) {
        String[] elements = inputFormatCheck(userInput);
        return null;
    }

    private String[] inputFormatCheck(String userInput) {
        String[] elements = userInput.split(",");
        if (elements.length != LottoConstants.LENGTH.getValue()) {
            throw new IllegalArgumentException();
        }
        return elements;
    }
}
