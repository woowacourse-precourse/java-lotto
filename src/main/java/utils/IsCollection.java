package utils;

public class IsCollection {

    public static boolean isDigitOrCommaText(String text) {
        return text.chars().allMatch(ch -> (Character.isDigit(ch) || ch == ','));
    }

    public static boolean isContain(String text, String inText) {
        return text.contains(inText);
    }

}
