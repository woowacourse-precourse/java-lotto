package lotto.utils;

import java.util.List;
import java.util.regex.Pattern;

public class ValidateUtils {
    public static boolean isNumber(String value){
        return Pattern.matches(Constants.NUMBER_REGEX, value);
    }

    public static boolean isInvalidLottoNumberLength(List<Integer> numbers){
        return numbers.size() != Constants.LOTTO_NUMBER_COUNT;
    }

    public static boolean isContainDuplicatedNumber(List<Integer> numbers){
        return numbers.size() != numbers.stream().distinct().count();
    }

    public static boolean isNumbersRangeOver(List<Integer> numbers){
        for(int number: numbers){
            if(isNumberRangeOver(number)){
                return true;
            }
        }
        return false;
    }

    public static boolean isNumberRangeOver(int number){
        if(number < Constants.LOTTO_MIN_NUMBER || number > Constants.LOTTO_MAX_NUMBER){
            return true;
        }
        return false;
    }

    public static void throwIllegalArgumentException(String message) throws IllegalArgumentException{
        throw new IllegalArgumentException(message);
    }
}
