package lotto.ui.dto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.util.Validator;

public class WinNumbers {
    private static final String DIAMETER = ",";

    private final String winNumbers;

    public WinNumbers(String winNumbers, Validator validator) {
        validator.validate(winNumbers);
        this.winNumbers = winNumbers;
    }

    public List<Integer> asList() {
        return Arrays.stream(winNumbers.split(DIAMETER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
