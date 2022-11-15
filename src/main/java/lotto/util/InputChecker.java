package lotto.util;

import lotto.domain.ErrorMessage;
import lotto.domain.Lotto;

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
        if(money%Lotto.LOTTO_PRICE!=0){
            throw new IllegalArgumentException(ErrorMessage.INPUT_IS_NOT_MULTIPLE_THOUSAND_ERROR.print());
        }
        return true;
    }
    public boolean isNumeric(String s){
        try{
            Integer.parseInt(s);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }
    public boolean isNotDuplication(Integer bonus, List<Integer> winningLotto) throws IllegalArgumentException{
        if(winningLotto.contains(bonus)){
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_DUPLICATION_ERROR.print());
        }
        return true;
    }
    public boolean isNumberInRange(Integer bonus) throws IllegalArgumentException{
        if(bonus<Lotto.MIN_LOTTO_NUMBERS || bonus>Lotto.MAX_LOTTO_NUMBERS){
            throw new IllegalArgumentException(ErrorMessage.LOTTO_RANGE_ERROR.print());
        }
        return true;
    }
    public boolean checkInputMoney(String input) throws IllegalArgumentException{
        if(!isDigit(input) || !isMultipleThousand(Integer.parseInt(input))){
            return false;
        }
        return true;
    }
    public boolean checkInputWinningLottoNumbersIsNumeric(List<String> inputWinningLottoNumbers) throws IllegalArgumentException{
        for(String number : inputWinningLottoNumbers){
            if(!isNumeric(number)){
                throw new IllegalArgumentException(ErrorMessage.INPUT_LOTTO_NUMBERS_NOT_NUMERIC.print());
            }
        }
        return true;
    }
    public boolean checkInputBonusNumber(String input, List<Integer> winningLotto) throws IllegalArgumentException{
        if(!isNumeric(input)){
            throw new IllegalArgumentException(ErrorMessage.INPUT_LOTTO_NUMBERS_NOT_NUMERIC.print());
        }
        if(isNotDuplication(Integer.parseInt(input), winningLotto) && isNumberInRange(Integer.parseInt(input))) {
            return true;
        }
        return false;
    }
}
