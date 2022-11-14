package lotto.utils;

import lotto.Lotto;

import java.util.List;

public class Validation {
    public static void validateBonus(int bonusNumber, List<Integer> lottoNumbers){
        if(lottoNumbers.contains(bonusNumber))
            throw new IllegalArgumentException();
    }

    public static void validateNumberRange(int number){
        if(number < 1 || number >45)
            throw new IllegalArgumentException();
    }

    public static void validateNumberDuplicate(List<Integer> lottoNumbers){
        if(lottoNumbers.stream().distinct().count()!=6)
            throw new IllegalArgumentException();
    }

    public static void validateMoneyRange(int money){
        if(money%1000!=0)
            throw new IllegalArgumentException();
    }

    public static void validateNotNumber(String[] s){
        for(int i=0;i<s.length;i++){
            if(s[i].chars().anyMatch(letter -> letter <'0' || letter > '9'))
                throw new IllegalArgumentException();
        }
    }
}
