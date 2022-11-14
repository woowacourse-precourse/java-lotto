package lotto.domain;

import lotto.exception.LottoException;

import java.util.ArrayList;
import java.util.List;

public class LuckyNumber {
    private Lotto luckyNumber;
    private int bonusNumber;

    public void inputLuckyNumber(String input){
        String[] arr = input.split(",");
        List<Integer> number = new ArrayList<>();

        for(String string : arr){
            validate(string);
            number.add(Integer.valueOf(string));
        }

        luckyNumber = new Lotto(number);
    }

    public void inputBonusNumber(String input){
        validate(input);
        bonusNumber = Integer.parseInt(input);
    }

    public Lotto getLuckyNumber(){
        return luckyNumber;
    }

    public int getBonusNumber(){
        return bonusNumber;
    }

    private void validate(String input){
        for(int i=0; i<input.length(); i++){
            char c = input.charAt(i);
            if(!Character.isDigit(c))
                throw new IllegalArgumentException(LottoException.NOT_DISIT.getErrorMessage());
        }

        int intInput = Integer.parseInt(input);

        if(intInput>45 || intInput<1)
            throw new IllegalArgumentException(LottoException.INVALID_NUMBER_RANGE.getErrorMessage());

    }
}
