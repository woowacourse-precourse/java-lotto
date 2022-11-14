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

    private int StringToASCII(String s){
        return s.charAt(0);
    }

    private int StringToInt(String s){
        validateNumber(s);
        return StringToASCII(s)-'0';
    }

    public boolean validateNumber(String s){
        int toInt = StringToASCII(s);
        if(toInt>Range.ASCII_MAX.get() || toInt<Range.ASCII_MIN.get()){
            throw new IllegalArgumentException(ErrorMessage.NUM_ERROR.getErrorMessage());
        }
        return true;
    }

    public boolean validateNumRange(String s) {
        int idxNum = StringToInt(s);
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
                lottoNum.add(s.charAt(0) - '0');
            }
        }
        validateLength(lottoNum);

        Set<Integer> inputSet = new HashSet<>(lottoNum);
        if (inputSet.size() != Range.DIGIT.get()){
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_ERROR.getErrorMessage());
        }
        return lottoNum;
    }

    private void validatePrice(int price){
        if (price%Range.PRICE.get()!=0){
            throw new IllegalArgumentException(ErrorMessage.PRICE_ERROR.getErrorMessage());
        }
    }

}
