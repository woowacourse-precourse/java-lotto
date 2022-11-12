package lotto;

import java.util.regex.Pattern;

public class ExceptionHandling {

    private static final String REGEX = "^[0-9]*$";

    public void notDivideException(long amount){
        if(amount % 1000 != 0 || amount <= 0){
            ShowErrorMessage.showNotDivide();
            throw new IllegalArgumentException();
        }
    }

    public void isNumeric(String value){
        if(!Pattern.matches(REGEX, value)){ // 숫자가 아니라면
            ShowErrorMessage.showOutRangeLottoNumber();
            throw new IllegalArgumentException();
        }
    }

}
