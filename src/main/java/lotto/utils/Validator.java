package lotto.utils;

import java.util.regex.Pattern;

public class Validator {
    public void isNumberOrNot(String input) {
        boolean isNumber = Pattern.matches("^[0-9]*$", input);
        if (!isNumber) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }

    public void isMultiplesOfThousand(String input) {
        int inputNumber = Integer.parseInt(input);
        if(inputNumber % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000의 배수만 입력 가능합니다.");
        }
    }
}
