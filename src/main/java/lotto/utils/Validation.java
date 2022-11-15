package lotto.utils;

import lotto.constant.CommonValue;
import lotto.constant.Regex;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validation {
    public static boolean isInteger(String str){
        return str.matches(Regex.INTEGER_REGEX);
    }

    public static boolean isCorrectSize(List<Integer> numbers) {
        return numbers.size() == CommonValue.LOTTO_NUMBER_COUNT;
    }

    public static boolean isUniqueNumber(List<Integer> numbers) {
        Set<Integer> numSet = new HashSet<>(numbers);
        return numSet.size() == numbers.size();
    }
}
