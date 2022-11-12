package lotto.domain;

import java.util.regex.Pattern;

public class Validator {

    public void validateNumeric(String amount){
        String numericPattern = "^[0-9]*$";
        if(!Pattern.matches(numericPattern, amount)){
            throw new IllegalArgumentException("[ERROR] 숫자형식이 아닙니다");
        }
    }
}
