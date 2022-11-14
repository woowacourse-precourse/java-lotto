package lotto.presentation.dto;

import lotto.support.Validator;

import java.util.ArrayList;
import java.util.List;

public class WinnerNumber {
    private static final int NUMBER_OF_DIGIT=6;
    private final List<Integer> winnerNumber;

    public WinnerNumber(String winnerNumber){
        List<String> result=firstValidate(winnerNumber);
        this.winnerNumber=stringToList(result);
        lastValidate(this.winnerNumber);
    }
    private List<String> firstValidate(String target){
        List<String> result=parser(target);
        for(String check:result) {
            Validator.checkInteger(check);
        }
        return result;
    }
    private void lastValidate(List<Integer> target){
        Validator.checkNumericalRange(target);
        Validator.checkNumberOfDigit(NUMBER_OF_DIGIT,target);
        Validator.checkDuplicate(target);
    }
    private List<String> parser(String target){
        List<String> parser=new ArrayList<>();
        StringBuilder temp= new StringBuilder();
        for(int i=0;i<target.length();i++){
            append(target,i,temp,parser);
        }
        parser.add(temp.toString());
        return parser;
    }
    private void append(String target,Integer index,StringBuilder builder,List<String> parser){
        if(target.charAt(index)!=','){
            builder.append(target.charAt(index));
        }
        if(target.charAt(index)==','){
            parser.add(builder.toString());
            builder.delete(0,builder.length());
        }
    }
    private List<Integer> stringToList(List<String> target){
        List<Integer> result=new ArrayList<>();
        for (String s : target) {
            result.add(Integer.parseInt(s));
        }
        return result;
    }
    public List<Integer> getWinnerNumber() {
        return winnerNumber;
    }
}
