package lotto.util.input;

import lotto.Lotto;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WinNumbers {
    private final Lotto winNumbers;
    private Set<Integer> winNumbersSet = new HashSet<>();

    public WinNumbers(String winNumbers) {
        this.winNumbers;
    }

    private void validateOnlyNumber (String winNumber) {
        String REGEX = "^[0-9]*[1-9]+$";
        if (!Pattern.matches(REGEX, winNumber)) {
            throw new IllegalArgumentException();
        }
    }
    private boolean validateDuplicateNumber () {
        return winNumbersSet.size() == 6;
    }
}
