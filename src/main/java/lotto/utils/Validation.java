package lotto.utils;

import lotto.constant.Regex;

public class Validation {
    public static boolean isInteger(String str){
        return str.matches(Regex.INTEGER_REGEX);
    }
}
