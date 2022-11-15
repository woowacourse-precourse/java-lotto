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



    private void validate(String input){
        for(int i=0; i<input.length(); i++){
            char c = input.charAt(i);
            if(!Character.isDigit(c))
                throw new IllegalArgumentException(LottoException.NOT_DISIT.getErrorMessage());
        }
    }
}
