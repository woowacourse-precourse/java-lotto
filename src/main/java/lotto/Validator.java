package lotto;

import lotto.enums.ErrorMessage;
import lotto.enums.Range;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    public List<Integer> inputNumber(String inputNum) {
        String[] inputN = inputNum.split(",");
        return checkDuplicated(inputN);
    }

    private int stringToInt(String s){
        validateNumber(s);
        return Integer.parseInt(s);
    }

    public void validateNumber(String s){
        for(int i=0;i<s.length();i++){
            if(!Character.isDigit(s.charAt(i))){
                throw new IllegalArgumentException(ErrorMessage.NUM_ERROR.getErrorMessage());
            }
        }
    }

    public boolean validateNumRange(String s) {
        int idxNum = stringToInt(s);
        if(idxNum > Range.MAX_RANGE.get() || idxNum < Range.MIN_RANGE.get()){
            throw new IllegalArgumentException(ErrorMessage.RANGE_ERROR.getErrorMessage());
        }
        return true;
    }

    public void validateLength(List<Integer> input){
        if(input.size()!= Range.DIGIT.get()){
            throw new IllegalArgumentException(ErrorMessage.LEN_ERROR.getErrorMessage());
        }
    }

    private List<Integer> checkDuplicated(String[] input){
        List<Integer> lottoNum = new ArrayList<>();
        for (String s : input) {
            if(validateNumRange(s)){
                lottoNum.add(stringToInt(s));
            }
        }
        validateLength(lottoNum);

        Set<Integer> inputSet = new HashSet<>(lottoNum);
        if (inputSet.size() != Range.DIGIT.get()){
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_ERROR.getErrorMessage());
        }
        return lottoNum;
    }

    public void validatePrice(String stringPrice){
        int price = stringToInt(stringPrice);
        if (price%Range.PRICE.get()!=0){
            throw new IllegalArgumentException(ErrorMessage.PRICE_ERROR.getErrorMessage());
        }
    }



}
