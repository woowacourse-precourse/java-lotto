package utils;

import constants.LottoConstant;

import java.util.List;

public class IsCollection {

    public static boolean isDigitOrCommaText(String text) {
        return text.chars().allMatch(ch -> (Character.isDigit(ch) || ch == ','));
    }

    public static boolean isContainText(String text, String inText) {
        return text.contains(inText);
    }

    public static boolean isSetSize(List<Integer> numbers, int setSize) {
        return numbers.size() == setSize;
    }

    public static boolean IsNumbersInRange(List<Integer> numbers, int start, int end) {
        return numbers.stream().allMatch(number -> number >= start && number <= end);
    }

    public static boolean isDuplication(List<Integer> numbers){
        return numbers.size() != numbers.stream().distinct().count();
    }


}
