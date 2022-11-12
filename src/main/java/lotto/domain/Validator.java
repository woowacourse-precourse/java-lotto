package lotto.domain;

import java.util.regex.Pattern;

import static lotto.utils.Messages.ERROR_MESSAGE;

public class Validator {

    public void validateNumeric(String input){
        String numericPattern = "^[0-9]*$";
        if(!Pattern.matches(numericPattern, input)){
            throw new IllegalArgumentException(ERROR_MESSAGE + "숫자형식이 아닙니다");
        }
    }
    public void validateGraterThousand(String input){
        int amount = Integer.parseInt(input);
        if(amount < 1000){
            throw new IllegalArgumentException(ERROR_MESSAGE + "1,000원 미만입니다.");
        }
    }

    public void validateMultipleOfThousands(String input){
        int amount = Integer.parseInt(input);
        if(amount % 1000 != 0){
            throw new IllegalArgumentException(ERROR_MESSAGE + "1,000의 단위가 아닙니다.");
        }
    }

}
