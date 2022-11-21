package lotto.exception;

import java.util.regex.Pattern;

public class ComputerNumberException {

    private static final String NOT_RIGHT_WINNING_NUMBERS = "[ERROR] 당첨 번호는 ,로 나누어진 1부터 45까지의 수 6개여야 합니다.";

    public void validate(String input){
        if(cannotMakeNumber(input)) notRightWinningNumberException();
    }

    private boolean cannotMakeNumber(String input){
        for(String splitted: input.split(",")){
            if(isNotNumber(splitted)) return true;
        }
        return false;
    }

    private void notRightWinningNumberException(){
        System.out.println(NOT_RIGHT_WINNING_NUMBERS);
        throw new IllegalArgumentException(NOT_RIGHT_WINNING_NUMBERS);
    }

    private boolean isNotNumber(String bonusNumber){
        return !Pattern.matches("^[0-9]*$", bonusNumber);
    }
}
