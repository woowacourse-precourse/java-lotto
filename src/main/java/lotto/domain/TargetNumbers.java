package lotto.domain;

import java.util.StringTokenizer;

public class TargetNumbers {
    private TargetNumbers(String input) {
        isInputFormValid(input);

    }

    public static TargetNumbers getInstance(String input) {
        return new TargetNumbers(input);
    }

    private void isInputFormValid(String input) throws IllegalArgumentException {
        StringTokenizer st=new StringTokenizer(input,",");

    }
}
