package lotto.presentation.dto;

import lotto.support.Validator;

import java.util.ArrayList;
import java.util.List;

public class WinnerNumber {
    private final Validator validator=Validator.getInstance();
    private List<Integer> winnerNumber;

    public WinnerNumber(String winnerNumber){
        winnerNumber=firstValidate(winnerNumber);
        this.winnerNumber=stringToList(winnerNumber);
        lastValidate(this.winnerNumber);
    }
    private String firstValidate(String target){
        target=target.replace(",","");
        validator.checkInteger(target);
        return target;
    }
    private void lastValidate(List<Integer> target){
        validator.checkNumericalRange(target);
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
