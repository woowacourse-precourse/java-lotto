package lotto.presentation.dto;

import lotto.support.Validator;

import java.util.ArrayList;
import java.util.List;

public class WinnerNumber {
    private static final int NUMBER_OF_DIGIT=6;
    private final List<Integer> winnerNumber;

    public WinnerNumber(String winnerNumber){
        winnerNumber=firstValidate(winnerNumber);
        this.winnerNumber=stringToList(winnerNumber);
        lastValidate(this.winnerNumber);
    }
    private String firstValidate(String target){
        target=target.replace(",","");
        Validator.checkInteger(target);
        return target;
    }
    private void lastValidate(List<Integer> target){
        Validator.checkNumericalRange(target);
        Validator.checkNumberOfDigit(NUMBER_OF_DIGIT,target);
        Validator.checkDuplicate(target);
    }
    private List<Integer> stringToList(String target){
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<target.length();i++){
            result.add(target.charAt(i)-'0');
        }
        return result;
    }

    public List<Integer> getWinnerNumber() {
        return winnerNumber;
    }
}
