package lotto;

import lotto.enums.ErrorMessage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoValidator {

    public List<Integer> inputNumber(String inputNum) {
        String[] inputN = inputNum.split(",");
        return checkDuplicated(inputN);
    }

    private int StringToInt(String s){
        return s.charAt(0) - '0';
    }

    private boolean validateNum(String s) {
        int idxNum = StringToInt(s);
        if(idxNum > 45 || idxNum < 1){
            throw new IllegalArgumentException();
        }
        return true;
    }

    private boolean validateLength(String[] input){
        if(input.length != 6){
            throw new IllegalArgumentException();
        }
        return true;
    }

    private List<Integer> checkDuplicated(String[] input){
        List<Integer> lottoNum = new ArrayList<>();

        for (String s : input) {
            if(validateNum(s) && validateLength(input))
            {
                lottoNum.add(s.charAt(0) - '0');
            }
        }

        Set<Integer> inputSet = new HashSet<>(lottoNum);
        if (inputSet.size() != 6){
            throw new IllegalArgumentException();
        }
        return lottoNum;
    }

}
