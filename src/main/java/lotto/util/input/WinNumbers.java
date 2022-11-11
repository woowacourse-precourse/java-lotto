package lotto.util.input;

import lotto.Lotto;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WinNumbers {
    private final int MAX_VALUE = 45;
    private final int MIN_VALUE = 1;
    private Lotto winNumbers;
    private Set<Integer> winNumbersSet = new HashSet<>();

    public WinNumbers(String winNumbers) {
        validate(winNumbers);
        this.winNumbers = new Lotto(winNumbersSet.stream().collect(Collectors.toList()));
    }

    public Lotto getWinNumbers() {
        return winNumbers;
    }

    private void validate(String winNumbers) {
        for (String winNumber : winNumbers.split(",")) {
            validateOnlyNumber(winNumber);
            validateNumberInRange(winNumber);

            winNumbersSet.add(Integer.parseInt(winNumber));
        }
    }

    private void validateOnlyNumber(String winNumber) {
        final String REGEX = "^[0-9]*$";
        if (!Pattern.matches(REGEX, winNumber)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNumberInRange(String winNumber) {
        int number = Integer.parseInt(winNumber);
        if (!(number >= MIN_VALUE && number <= MAX_VALUE)) {
            throw new IllegalArgumentException();
        }
    }
}
