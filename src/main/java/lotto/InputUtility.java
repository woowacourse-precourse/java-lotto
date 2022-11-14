package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class InputUtility {
    static List<Integer> convertToIntegerList(String[] splitInput){
        List<Integer> splitNumber = new ArrayList<>();
        for(String number : splitInput){
            splitNumber.add(convertToInteger(number));
        }
        return splitNumber;
    }
    static Integer convertToInteger(String number){
        return Integer.parseInt(number);
    }
    static void isValidLength(String[] splitInput, int testLength){
        if(splitInput.length!=testLength){
            throw new IllegalArgumentException("[ERROR] 분리된 문자열의 수가 잘못됐습니다");
        }
    }
    static void isDigit(String input){
        if(!input.chars().allMatch(Character::isDigit)){
            System.out.println("[ERROR]");
            throw new IllegalArgumentException("[ERROR] 분리된 문자열이 숫자가 아닙니다.");
        }
    }
    static void isAllDigit(String[] splitInput){
        for(String number : splitInput){
            isDigit(number);
        }
    }
    static void testNoDuplicate(List<Integer> splitNumber){
        HashSet<Integer> hashsetNumber = new HashSet<>(splitNumber);
        if(hashsetNumber.size() != splitNumber.size()){
            throw new IllegalArgumentException("[ERROR] 중복되는 숫자가 있습니다.");
        }
    }
}
