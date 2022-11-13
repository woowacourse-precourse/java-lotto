package lotto;

import java.util.ArrayList;
import java.util.List;

public class StringConverter {
    static List<Integer> convertToIntegerL(String[] splitInput){
        List<Integer> splitNumber = new ArrayList<>();
        for(String number : splitInput){
            splitNumber.add(Integer.parseInt(number));
        }
        return splitNumber;
    }
    static void isValidLength(String[] splitInput, int testLength){
        if(splitInput.length!=testLength){
            throw new IllegalArgumentException("ERROR : 분리된 문자열의 수가 잘못됐습니다");
        }
    }
    static void isDigit(String input){
        if(!input.chars().allMatch(Character::isDigit)){
            throw new IllegalArgumentException("ERROR : 분리된 문자열이 숫자가 아닙니다.");
        }
    }
    static void isAllDigit(String[] splitInput){
        for(String number : splitInput){
            isDigit(number);
        }
    }
}
