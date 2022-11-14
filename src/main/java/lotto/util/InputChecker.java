package lotto.util;

import lotto.ErrorMessage;

import java.util.List;

public class InputChecker {
    public boolean isDigit(String input) throws IllegalArgumentException{
        for(int i=0; i<input.length(); i++){
            if(!Character.isDigit(input.charAt(i))){
                throw new IllegalArgumentException(ErrorMessage.INPUT_IS_NOT_DIGIT_ERROR.print());
            }
        }
        return true;
    }
    public boolean isMultipleThousand(int money) throws IllegalArgumentException{
        if(money%1000!=0){
            throw new IllegalArgumentException(ErrorMessage.INPUT_IS_NOT_MULTIPLE_THOUSAND_ERROR.print());
        }
        return true;
    }
    public boolean isSizeSix(List<String> inputWinningLottoNumbers)throws IllegalArgumentException{
        if(inputWinningLottoNumbers.size()!=6){
            throw new IllegalArgumentException(ErrorMessage.LOTTO_SIZE_ERROR.print());
        }
        return true;
    }
    public boolean checkInputMoney(String input) throws IllegalArgumentException{
        if(!isDigit(input) || !isMultipleThousand(Integer.parseInt(input))){
            return false;
        }
        return true;
    }
    public boolean checkInputWinningLottoNumbers(List<String> inputWinningLottoNumbers) throws IllegalArgumentException{
        if(!isSizeSix(inputWinningLottoNumbers)) return false;
        return true;
    }
}
