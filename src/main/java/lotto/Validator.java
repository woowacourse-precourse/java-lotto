package lotto;

import java.util.HashSet;
import java.util.List;

public class Validator {
    public static boolean isAllNumber(String string){
        for (int i = 0; i < string.length(); i++) {
            if (Character.isDigit(string.charAt(i)) == false){
                return false;
            }
        }
        return true;
    }

    public static boolean isValidFormat(String string){
        int count = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == ','){
                count++;
            }
        }
        if (count != 5){
            return false;
        }
        return true;
    }

    public static boolean isDuplicated(List<Integer> numbers){
        return new HashSet<Integer>(numbers).size() != numbers.size();
    }

    public static boolean isProperRange(List<Integer> numbers, int start, int end){
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) < start){
                return false;
            }
            if (numbers.get(i) > end){
                return false;
            }
        }
        return true;
    }
}
