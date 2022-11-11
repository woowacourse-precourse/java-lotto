package lotto.ui.dto;

import lotto.util.Validator;

public class WinNumbers {
    private final String winNumbers;

    public WinNumbers(String winNumbers, Validator validator) {
        validator.validate(winNumbers);
        this.winNumbers = winNumbers;
    }
}
