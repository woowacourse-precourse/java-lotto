package lotto.domain;

import lotto.ErrorMessage;

public class InputChecker {
    public boolean isDigit(String input) throws IllegalArgumentException{
        for(int i=0; i<input.length(); i++){
            if(!Character.isDigit(input.charAt(i))){
                throw new IllegalArgumentException(ErrorMessage.INPUT_IS_NOT_DIGIT_ERROR.print());
            }
        }
        return true;
    }
    public boolean checkInputMoney(String input) throws IllegalArgumentException{
        /*
        1. 숫자 인지 체크
        2. 숫자면 1000으로 나누어 떨어지는지 체크
         */
        if(!isDigit(input)){
            return false;
        }
        return true;
    }
}
